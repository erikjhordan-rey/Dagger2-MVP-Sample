

package gdg.androidtitlan.dagger2_demo.ui.main;

import java.util.List;

/**
 * Created by Jhordan on 07/12/15.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<Category> categories);

    void showMessage(String message);
}
