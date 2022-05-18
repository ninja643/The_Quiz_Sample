package rs.ac.ni.pmf.quiz.db.model;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class QuestionWithUsers {
    @Embedded
    public Question question;

    @Relation(
            entity = User.class,
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(
                    value = UserQuestionCrossRef.class,
                    parentColumn = "question_id",
                    entityColumn = "user_id")
    )
    public List<User> users;
}
