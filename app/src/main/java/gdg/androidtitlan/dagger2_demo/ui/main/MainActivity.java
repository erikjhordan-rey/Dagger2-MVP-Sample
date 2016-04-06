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
package gdg.androidtitlan.dagger2_demo.ui.main;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import gdg.androidtitlan.dagger2_demo.AppComponent;
import gdg.androidtitlan.dagger2_demo.R;
import gdg.androidtitlan.dagger2_demo.ui.common.BaseActivity;

public class MainActivity extends BaseActivity
    implements MainView, AdapterView.OnItemClickListener {

  @Inject MainPresenter presenter;
  private ProgressBar progressBar;
  private RecyclerView recyclerView;

  @Override protected void setupComponent(AppComponent appComponent) {

    DaggerMainComponent.builder()
        .appComponent(appComponent)
        .mainModule(new MainModule(this))
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

  @Override public void setItems(List<Category> items) {

    CategoryAdapter categoryAdapter = new CategoryAdapter();
    categoryAdapter.setCategories(items);
    recyclerView.setAdapter(categoryAdapter);
  }

  @Override public void showMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
  }

  @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    presenter.onItemSelected(position);
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
}
