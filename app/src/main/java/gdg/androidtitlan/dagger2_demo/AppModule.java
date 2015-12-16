

package gdg.androidtitlan.dagger2_demo;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jhordan on 07/12/15.
 */

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton public Application provideApplication() {
        return app;
    }
}
