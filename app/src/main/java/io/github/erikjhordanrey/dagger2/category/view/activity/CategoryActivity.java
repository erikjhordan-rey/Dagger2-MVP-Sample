/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.erikjhordanrey.dagger2.category.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import io.github.erikjhordanrey.dagger2.category.adapter.CategoryAdapter;
import io.github.erikjhordanrey.dagger2.category.model.Category;
import io.github.erikjhordanrey.dagger2.category.view.presenter.CategoryPresenter;
import io.github.erikjhordanrey.dagger2.category.view.presenter.Presenter;
import io.github.erikjhordanrey.dagger2.common.BaseActivity;
import gdg.androidtitlan.dagger2.databinding.ActivityCategoryBinding;
import io.github.erikjhordanrey.dagger2.di.component.AppComponent;
import io.github.erikjhordanrey.dagger2.di.component.DaggerCategoryComponent;
import io.github.erikjhordanrey.dagger2.di.module.CategoryModule;
import java.util.List;
import javax.inject.Inject;

public class CategoryActivity extends BaseActivity implements CategoryPresenter.View, CategoryAdapter.ItemClickListener {

    private ActivityCategoryBinding binding;
    private CategoryAdapter categoryAdapter = new CategoryAdapter();

    @Inject
    Presenter presenter;

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerCategoryComponent.builder()
                .appComponent(appComponent)
                .categoryModule(new CategoryModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
        setUpToolbar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void showProgress() {
        binding.progress.setVisibility(View.VISIBLE);
        binding.rvCategorys.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.progress.setVisibility(View.INVISIBLE);
        binding.rvCategorys.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCategories(List<Category> items) {
        categoryAdapter.setCategories(items);
        categoryAdapter.setItemClickListener(this);
        binding.rvCategorys.setAdapter(categoryAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        setSupportActionBar(binding.toolbar);
    }

    private void setUpToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }

    @Override
    public void onItemClick(Category category, int position) {
        presenter.onItemSelected(category, position);
    }
}
