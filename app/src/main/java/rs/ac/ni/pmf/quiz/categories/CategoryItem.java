package rs.ac.ni.pmf.quiz.categories;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import rs.ac.ni.pmf.quiz.BR;
import rs.ac.ni.pmf.quiz.db.model.Category;

public class CategoryItem extends BaseObservable {
    private final Category category;
    private boolean selected;

    public CategoryItem(Category category, boolean selected) {
        this.category = category;
        this.selected = selected;
    }

    public Category getCategory() {
        return category;
    }

    @Bindable
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        notifyPropertyChanged(BR.selected);
    }
}
