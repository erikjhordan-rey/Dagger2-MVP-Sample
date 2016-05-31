/**
 * Copyright 2015 Erik Jhordan Rey.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gdg.androidtitlan.dagger2_demo.adapter;

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
import gdg.androidtitlan.dagger2_demo.mvp.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categories;
    private ItemClickListener itemClickListener;

    public CategoryAdapter() {
        categories = Collections.emptyList();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int position) {
        final Category category = categories.get(position);
        bind(holder, category);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) itemClickListener.onItemClick(category, position);
            }
        });
    }

    private void bind(CategoryViewHolder holder, Category category) {
        holder.textView.setText(category.getName());
        holder.textView.setBackgroundColor(
                getColor(holder.textView.getContext(), category.getPrimaryColor()));
        holder.imageView.setImageResource(category.getIcon());
        holder.imageView.setBackgroundColor(
                getColor(holder.imageView.getContext(), category.getBackgroundColor()));
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

        View itemView;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public interface ItemClickListener {
        void onItemClick(Category category, int position);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
