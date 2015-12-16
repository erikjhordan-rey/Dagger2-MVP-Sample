package gdg.androidtitlan.dagger2_demo.ui.main;


import dagger.Component;
import gdg.androidtitlan.dagger2_demo.ActivityScope;
import gdg.androidtitlan.dagger2_demo.AppComponent;

/**
 * Created by Jhordan on 07/12/15.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {
    void inject(MainActivity mainActivity);

    MainPresenter getMainPresenter();

}
