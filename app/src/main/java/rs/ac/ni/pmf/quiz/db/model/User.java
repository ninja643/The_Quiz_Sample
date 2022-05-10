package rs.ac.ni.pmf.quiz.db.model;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "users", indices = @Index(value = "username", unique = true))
public class User {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    public String username;

    public String password;

    public String email;
}
