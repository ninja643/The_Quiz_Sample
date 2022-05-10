package rs.ac.ni.pmf.quiz.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rs.ac.ni.pmf.quiz.db.model.Category;
import rs.ac.ni.pmf.quiz.db.model.Question;
import rs.ac.ni.pmf.quiz.db.model.User;
import rs.ac.ni.pmf.quiz.db.model.UserQuestionCrossRef;

@Database(
        entities = {Question.class, User.class, Category.class, UserQuestionCrossRef.class},
        version = 2
)
public abstract class QuizDatabase extends RoomDatabase {
    private static QuizDatabase INSTANCE;
    private static final ExecutorService _databaseExecutor = Executors.newFixedThreadPool(2);
    private static final ListeningExecutorService _listeningExecutorService =
            MoreExecutors.listeningDecorator(_databaseExecutor);

    public static QuizDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (QuizDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), QuizDatabase.class, "quiz_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    public abstract UserDao userDao();

    public abstract QuestionDao questionDao();

    public abstract CategoryDao categoryDao();

    public void execute(final Runnable task) {
        _databaseExecutor.execute(task);
    }

    public <T> ListenableFuture<T> schedule(Callable<T> task) {
        return _listeningExecutorService.submit(task);
    }
}
