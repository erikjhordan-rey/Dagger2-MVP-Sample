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

package gdg.androidtitlan.dagger2_demo.categories;

import gdg.androidtitlan.dagger2_demo.model.Category;
import java.util.List;

import gdg.androidtitlan.dagger2_demo.interactors.CategoryInteractor;

public class MainPresenterImpl implements MainPresenter, Callback {

  private MainView mainView;
  private CategoryInteractor categoryInteractor;

  public MainPresenterImpl(MainView mainView, CategoryInteractor categoryInteractor) {
    this.mainView = mainView;
    this.categoryInteractor = categoryInteractor;
  }

  @Override public void onResume() {
    mainView.showProgress();
    categoryInteractor.loadCategories(this);
  }

  @Override public void onItemSelected(Category category, int position) {
    mainView.showMessage(String.format(category.getName() +" ->" +" Position %d clicked", position));
  }

  @Override public void onLoadCategories(List<Category> categories) {
    mainView.showCategories(categories);
    mainView.hideProgress();
  }
}
