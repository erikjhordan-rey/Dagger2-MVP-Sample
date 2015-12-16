package gdg.androidtitlan.dagger2_demo;


import javax.inject.Singleton;

import dagger.Component;

import gdg.androidtitlan.dagger2_demo.interactors.CategoryInteractor;
import gdg.androidtitlan.dagger2_demo.interactors.InteractorsModule;


/**
 * Created by Jhordan on 07/12/15.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                InteractorsModule.class
        }
)
public interface AppComponent {
    void inject(App app);

    CategoryInteractor getFindItemsInteractor();
}
