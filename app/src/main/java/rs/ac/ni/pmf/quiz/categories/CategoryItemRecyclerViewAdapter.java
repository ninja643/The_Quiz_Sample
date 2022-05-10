package rs.ac.ni.pmf.quiz.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import rs.ac.ni.pmf.quiz.databinding.CategoryItemViewBinding;

public class CategoryItemRecyclerViewAdapter extends RecyclerView.Adapter<CategoryItemRecyclerViewAdapter.CategoryItemViewHolder> {

    private final List<CategoryItem> _categoryItems;

    public CategoryItemRecyclerViewAdapter(List<CategoryItem> categoryItems) {
        _categoryItems = categoryItems;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(CategoryItemViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {
        holder.getBinding().setCategoryItem(_categoryItems.get(position));
    }

    @Override
    public int getItemCount() {
        return _categoryItems.size();
    }

    public class CategoryItemViewHolder extends RecyclerView.ViewHolder {

        private final CategoryItemViewBinding _binding;

        public CategoryItemViewHolder(final CategoryItemViewBinding binding) {
            super(binding.getRoot());
            _binding = binding;
        }

        public CategoryItemViewBinding getBinding() {
            return _binding;
        }
    }
}
