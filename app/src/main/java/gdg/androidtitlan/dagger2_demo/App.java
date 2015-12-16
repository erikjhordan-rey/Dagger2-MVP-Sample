

package gdg.androidtitlan.dagger2_demo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Jhordan on 07/12/15.
 */
public class App extends Application {

    private AppComponent component;


    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();

    }

    private void setupGraph() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
}