package rs.ac.ni.pmf.quiz.db;

import android.content.Context;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import rs.ac.ni.pmf.quiz.db.model.Category;
import rs.ac.ni.pmf.quiz.db.model.Question;

public class QuestionsRepository {

    private final QuestionDao _questionsDao;

    public QuestionsRepository(final Context context) {
        final QuizDatabase quizDatabase = QuizDatabase.getInstance(context);
        _questionsDao = quizDatabase.questionDao();
    }

    public List<Question> findAll() {
        return _questionsDao.findAll();
    }

    public List<Question> getQuestionsByCategories(Set<Category> selectedCategories, int limit) {
        return _questionsDao.getQuestions(
                selectedCategories.stream().map(Category::getId).collect(Collectors.toList()),
                limit);
    }
}
