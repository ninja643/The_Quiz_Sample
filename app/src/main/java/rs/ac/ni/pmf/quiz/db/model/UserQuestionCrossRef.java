package rs.ac.ni.pmf.quiz.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "users_questions", primaryKeys = {"user_id", "question_id"})
public class UserQuestionCrossRef {
    @ColumnInfo(name = "user_id")
    public long userId;
    @ColumnInfo(name = "question_id")
    public long questionId;

//    @ColumnInfo(name = "selected_answer")
//    public Integer selectedAnswer;
}
