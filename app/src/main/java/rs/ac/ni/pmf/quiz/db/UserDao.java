package rs.ac.ni.pmf.quiz.db;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import rs.ac.ni.pmf.quiz.db.model.UserWithQuestions;

@Dao
public interface UserDao {
    @Transaction
    @Query("SELECT * FROM users WHERE username = :username")
    public List<UserWithQuestions> getQuestionsByUsername(String username);
}
