package rs.ac.ni.pmf.quiz.db.model;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class QuestionWithUsers {
    @Embedded
    public Question question;

    @Relation(
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(UserQuestionCrossRef.class)
    )
    public List<User> users;
}
