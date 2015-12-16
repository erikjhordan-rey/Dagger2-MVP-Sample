

package gdg.androidtitlan.dagger2_demo.ui.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import gdg.androidtitlan.dagger2_demo.App;
import gdg.androidtitlan.dagger2_demo.AppComponent;

/**
 * Created by Jhordan on 07/12/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent((AppComponent) App.get(this).component());
    }

    protected abstract void setupComponent(AppComponent appComponent);
}
