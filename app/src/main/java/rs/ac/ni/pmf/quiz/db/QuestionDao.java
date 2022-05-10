package rs.ac.ni.pmf.quiz.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import rs.ac.ni.pmf.quiz.db.model.Question;

@Dao
public interface QuestionDao {
    @Insert
    void insertQuestion(Question question);

    @Query("SELECT * FROM questions")
    List<Question> findAll();

    @Query("SELECT * FROM questions WHERE category_id IN (:selectedCategoriesIds) LIMIT :limit")
    List<Question> getQuestions(List<Long> selectedCategoriesIds, int limit);
}
