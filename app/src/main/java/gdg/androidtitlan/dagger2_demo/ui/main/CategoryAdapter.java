package gdg.androidtitlan.dagger2_demo.ui.main;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import gdg.androidtitlan.dagger2_demo.R;


/**
 * Created by Jhordan on 20/11/15.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categories;

    public CategoryAdapter() {
        categories = Collections.emptyList();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category category = categories.get(position);

        holder.textView.setText(category.getName());
        holder.textView.setBackgroundColor(getColor(holder.textView.getContext(), category.getPrimaryColor()));
        holder.imageView.setImageResource(category.getIcon());
        holder.imageView.setBackgroundColor(getColor(holder.imageView.getContext(), category.getBackgroundColor()));

    }

    private int getColor(Context context, @ColorRes int colorRes) {
        return ContextCompat.getColor(context, colorRes);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.image_category_icon)
        ImageView imageView;

        @Bind(R.id.label_category_name)
        TextView textView;


        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


}
