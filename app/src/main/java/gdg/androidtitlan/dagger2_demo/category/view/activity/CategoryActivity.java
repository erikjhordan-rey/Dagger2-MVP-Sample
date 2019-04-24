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

package gdg.androidtitlan.dagger2_demo.category.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import gdg.androidtitlan.dagger2_demo.R;
import gdg.androidtitlan.dagger2_demo.category.adapter.CategoryAdapter;
import gdg.androidtitlan.dagger2_demo.category.model.Category;
import gdg.androidtitlan.dagger2_demo.category.view.presenter.CategoryPresenter;
import gdg.androidtitlan.dagger2_demo.category.view.presenter.Presenter;
import gdg.androidtitlan.dagger2_demo.common.BaseActivity;
import gdg.androidtitlan.dagger2_demo.di.component.AppComponent;
import gdg.androidtitlan.dagger2_demo.di.component.DaggerCategoryComponent;
import gdg.androidtitlan.dagger2_demo.di.module.CategoryModule;

public class CategoryActivity extends BaseActivity
    implements CategoryPresenter.View, CategoryAdapter.ItemClickListener {

  @Inject Presenter presenter;
  private ProgressBar progressBar;
  private RecyclerView recyclerView;

  @Override protected void setupComponent(AppComponent appComponent) {

    DaggerCategoryComponent.builder()
        .appComponent(appComponent)
        .categoryModule(new CategoryModule(this))
        .build()
        .inject(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_category);
    initViews();
    setUpToolbar();
  }

  @Override protected void onResume() {
    super.onResume();
    presenter.onResume();
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
    recyclerView.setVisibility(View.INVISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
    recyclerView.setVisibility(View.VISIBLE);
  }

  @Override public void showCategories(List<Category> items) {

    CategoryAdapter categoryAdapter = new CategoryAdapter();
    categoryAdapter.setCategories(items);
    categoryAdapter.setItemClickListener(this);
    recyclerView.setAdapter(categoryAdapter);
  }

  @Override public void showMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  private void initViews() {
    recyclerView = (RecyclerView) findViewById(R.id.rv_categorys);
    progressBar = (ProgressBar) findViewById(R.id.progress);

    Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(mToolbar);
  }

  private void setUpToolbar() {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(false);
      actionBar.setDisplayShowTitleEnabled(true);
    }
  }

  @Override public void onItemClick(Category category, int position) {
    presenter.onItemSelected(category, position);
  }
}
