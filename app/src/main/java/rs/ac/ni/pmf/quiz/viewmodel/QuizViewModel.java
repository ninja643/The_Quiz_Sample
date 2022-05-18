package rs.ac.ni.pmf.quiz.viewmodel;

import android.app.Application;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import rs.ac.ni.pmf.quiz.categories.CategoryItem;
import rs.ac.ni.pmf.quiz.db.CategoriesRepository;
import rs.ac.ni.pmf.quiz.db.model.Category;

public class QuizViewModel extends AndroidViewModel {
    private final LiveData<List<Category>> _categories = new MutableLiveData<>();
    private final Set<Category> _selectedCategories = new HashSet<>();

    private final CategoriesRepository _categoriesRepository;

    public QuizViewModel(@NonNull Application application) {
        super(application);
        _categoriesRepository = new CategoriesRepository(application);
    }

    public LiveData<List<Category>> getCategories() {
        return _categoriesRepository.findAll();
    }

    public void addCategory(Category category) {
        final String categoryName = category.getName().toUpperCase(Locale.ROOT);
        if (_categories.getValue() != null && _categories.getValue().stream().map(Category::getName).anyMatch(name -> name.toUpperCase(Locale.ROOT).equals(categoryName))) {
            Log.d("LOGTAG", "Category " + categoryName + " already exists");
            Toast.makeText(getApplication().getApplicationContext(), "Duplicate category: " + categoryName, Toast.LENGTH_SHORT).show();
            return;
        }

        _categoriesRepository.addCategory(category);
    }

    public Set<Category> getSelectedCategories() {
        return _selectedCategories;
    }
}
