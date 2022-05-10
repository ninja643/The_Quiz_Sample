package rs.ac.ni.pmf.quiz.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions",
        foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "category_id"))
public class Question {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo(name = "category_id")
    public Long categoryId;

    public String question;

    public String option1;
    public String option2;
    public String option3;

    public int answer;

    public Question(Long categoryId, String question, String option1, String option2, String option3, int answer) {
        this.categoryId = categoryId;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public int getAnswer() {
        return answer;
    }
}
