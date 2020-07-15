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

package gdg.androidtitlan.dagger2_demo.category.view.presenter;

import gdg.androidtitlan.dagger2_demo.category.model.Callback;
import gdg.androidtitlan.dagger2_demo.category.model.Categories;
import gdg.androidtitlan.dagger2_demo.category.model.Category;
import java.util.List;

public class CategoryPresenter implements Presenter, Callback {

    private View view;
    private Categories categories;

    public CategoryPresenter(View view, Categories categories) {
        this.view = view;
        this.categories = categories;
    }

    @Override
    public void onResume() {
        view.showProgress();
        categories.getCategories(this);
    }

    @Override
    public void onItemSelected(Category category, int position) {
        view.showMessage(String.format(category.getName() + " ->" + " Position %d clicked", position));
    }

    @Override
    public void onLoadCategories(List<Category> categories) {
        view.showCategories(categories);
        view.hideProgress();
    }

    public interface View {

        void showProgress();

        void hideProgress();

        void showCategories(List<Category> categories);

        void showMessage(String message);
    }
}
