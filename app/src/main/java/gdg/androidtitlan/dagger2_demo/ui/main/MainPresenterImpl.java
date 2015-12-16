
package gdg.androidtitlan.dagger2_demo.ui.main;


import java.util.List;

import gdg.androidtitlan.dagger2_demo.interactors.CategoryInteractor;

public class MainPresenterImpl implements MainPresenter, CallBack {

    private MainView mainView;
    private CategoryInteractor categoryInteractor;

    public MainPresenterImpl(MainView mainView, CategoryInteractor categoryInteractor) {
        this.mainView = mainView;
        this.categoryInteractor = categoryInteractor;
    }

    @Override
    public void onResume() {
        mainView.showProgress();
        categoryInteractor.findItems(this);
    }

    @Override
    public void onItemSelected(int position) {
        mainView.showMessage(String.format("Position %d clicked", position + 1));
    }

    @Override
    public void onFinished(List<Category> items) {
        mainView.setItems(items);
        mainView.hideProgress();
    }
}
