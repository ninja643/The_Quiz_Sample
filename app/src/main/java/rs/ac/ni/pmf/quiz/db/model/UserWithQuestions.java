package rs.ac.ni.pmf.quiz.db.model;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UserWithQuestions {
    @Embedded
    public User user;

    @Relation(
            entity = Question.class,
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(
                    value = UserQuestionCrossRef.class,
                    parentColumn = "user_id",
                    entityColumn = "question_id"))
    public List<Question> questions;
}
