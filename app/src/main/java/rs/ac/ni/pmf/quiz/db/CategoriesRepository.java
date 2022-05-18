package rs.ac.ni.pmf.quiz.db;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

import rs.ac.ni.pmf.quiz.db.model.Category;

public class CategoriesRepository {
    private final QuizDatabase _quizDatabase;
    private final CategoryDao _categoryDao;

    private final FutureCallback<Long> addCategoryCallback = new FutureCallback<Long>() {
        @Override
        public void onSuccess(Long result) {
            Log.i("LOGTAG", "Added a new category with id: " + result);
        }

        @Override
        public void onFailure(Throwable t) {
            Log.e("LOGTAG", "Failed to add category, Error: " + t.getLocalizedMessage());
        }
    };

    public CategoriesRepository(final Context context) {
        _quizDatabase = QuizDatabase.getInstance(context);
        _categoryDao = _quizDatabase.categoryDao();
    }

    public LiveData<List<Category>> findAll() {
        return _categoryDao.findAll();
    }

    public void addCategory(Category category) {
//        _quizDatabase.execute(() -> _categoryDao.addCategory(category));
        _quizDatabase.submit(() -> _categoryDao.addCategory(category), addCategoryCallback);
    }
}
