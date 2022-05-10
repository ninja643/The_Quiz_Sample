package rs.ac.ni.pmf.quiz.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories", indices = {@Index(value = "name", unique = true)})
public class Category {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
