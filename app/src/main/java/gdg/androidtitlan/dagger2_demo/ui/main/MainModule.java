

package gdg.androidtitlan.dagger2_demo.ui.main;



import dagger.Module;
import dagger.Provides;
import gdg.androidtitlan.dagger2_demo.interactors.CategoryInteractor;

/**
 * Created by Jhordan on 07/12/15.
 */
@Module
public class MainModule {

    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    public MainView provideView() {
        return view;
    }

    @Provides
    public MainPresenter providePresenter(MainView mainView, CategoryInteractor categoryInteractor) {
        return new MainPresenterImpl(mainView, categoryInteractor);
    }
}
