

package gdg.androidtitlan.dagger2_demo.interactors;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorsModule {

    @Provides public CategoryInteractor provideFindItemsInteractor() {
        return new CategoryInteractorImpl();
    }


}
