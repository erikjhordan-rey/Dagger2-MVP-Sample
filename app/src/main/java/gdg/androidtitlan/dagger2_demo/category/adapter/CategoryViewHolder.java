package gdg.androidtitlan.dagger2_demo.category.adapter;

import androidx.annotation.NonNull;
import static androidx.core.content.ContextCompat.getColor;
import androidx.recyclerview.widget.RecyclerView;
import gdg.androidtitlan.dagger2_demo.category.model.Category;
import gdg.androidtitlan.dagger2_demo.databinding.ItemCategoryBinding;

class CategoryViewHolder extends RecyclerView.ViewHolder {

    private ItemCategoryBinding binding;

    CategoryViewHolder(@NonNull ItemCategoryBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(Category category) {
        binding.labelCategoryName.setText(category.getName());
        binding.labelCategoryName.setBackgroundColor(getColor(binding.labelCategoryName.getContext(), category.getPrimaryColor()));
        binding.imageCategoryIcon.setImageResource(category.getIcon());
        binding.imageCategoryIcon.setBackgroundColor(getColor(binding.imageCategoryIcon.getContext(), category.getBackgroundColor()));
    }
}
