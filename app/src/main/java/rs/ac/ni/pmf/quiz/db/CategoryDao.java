package rs.ac.ni.pmf.quiz.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import rs.ac.ni.pmf.quiz.db.model.Category;

@Dao
public interface CategoryDao {
    @Insert
    long addCategory(Category category);

    @Query("DELETE FROM categories WHERE name = :categoryName")
    void deleteCategory(String categoryName);

    @Query("SELECT * FROM categories")
    LiveData<List<Category>> findAll();
}
