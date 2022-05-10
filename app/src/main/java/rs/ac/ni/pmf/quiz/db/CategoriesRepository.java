package rs.ac.ni.pmf.quiz.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import rs.ac.ni.pmf.quiz.db.model.Category;

public class CategoriesRepository {
    private final QuizDatabase _quizDatabase;
    private final CategoryDao _categoryDao;

    public CategoriesRepository(final Context context) {
        _quizDatabase = QuizDatabase.getInstance(context);
        _categoryDao = _quizDatabase.categoryDao();
    }

    public LiveData<List<Category>> findAll() {
        return _categoryDao.findAll();
    }

    public void addCategory(Category category) {
        _quizDatabase.execute(() -> _categoryDao.addCategory(category));
    }
}
