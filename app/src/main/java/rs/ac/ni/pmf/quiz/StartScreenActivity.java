package rs.ac.ni.pmf.quiz;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import rs.ac.ni.pmf.quiz.categories.CategoryItem;
import rs.ac.ni.pmf.quiz.categories.CategoryItemRecyclerViewAdapter;
import rs.ac.ni.pmf.quiz.db.model.Category;
import rs.ac.ni.pmf.quiz.viewmodel.QuizViewModel;

public class StartScreenActivity extends AppCompatActivity implements AddCategoryDialog.AddCategoryDialogListener {

    private static final String ADD_CATEGORY_DIALOG = "ADD_CATEGORY_DIALOG";

    private ActivityResultLauncher<String> _quizActivityLauncher;
    private QuizViewModel _quizViewModel;

    private String _username = "USER";

    private RecyclerView _categoriesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        _quizViewModel = new ViewModelProvider(this).get(QuizViewModel.class);
        _quizActivityLauncher = registerForActivityResult(QuizActivity.QUIZ_CONTRACT, this::onQuizFinished);

        final Button startQuizButton = findViewById(R.id.button_start_quiz);
        startQuizButton.setOnClickListener(this::startQuiz);

        _categoriesRecyclerView = findViewById(R.id.categories_list);
        _categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        _quizViewModel.getCategories()
                .observe(
                        this,
                        categories -> setAdapter(categories, _quizViewModel.getSelectedCategories()));
    }

    public void setAdapter(List<Category> categories, Set<Category> selectedCategories) {
        final List<CategoryItem> categoryItems = categories.stream()
                .map(category -> new CategoryItem(category, selectedCategories.contains(category)))
                .collect(Collectors.toList());
        _categoriesRecyclerView.setAdapter(new CategoryItemRecyclerViewAdapter(categoryItems));
    }

    private void startQuiz(View view) {
        _quizActivityLauncher.launch(_username);
    }

    private void onQuizFinished(final Integer result) {
        Log.i("QUIZ", "Result: " + result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_add_category) {
            showAddCategoryDialog();
            return true;
        }

        if (item.getItemId() == R.id.menu_manage_questions) {
            manageQuestions();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showAddCategoryDialog() {
        new AddCategoryDialog().show(getSupportFragmentManager(), ADD_CATEGORY_DIALOG);
    }

    private void manageQuestions() {

    }

    @Override
    public void onAddCategory(final String category) {
        _quizViewModel.addCategory(new Category(category));
    }
}