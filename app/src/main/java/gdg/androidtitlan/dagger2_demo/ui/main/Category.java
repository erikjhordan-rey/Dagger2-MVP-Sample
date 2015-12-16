package gdg.androidtitlan.dagger2_demo.ui.main;

/**
 * Created by Jhordan on 08/12/15.
 */
public class Category {

    //TODO In your real projects Do not do this please!!! you can use  " ENUM "!

    /* Look this example
     * https://github.com/googlesamples/android-topeka/blob/master/app/src/main/java/com/google/samples/apps/topeka/model/Theme.java
     */

    private String mName;
    private int mIcon;
    private int mBackgroundColor;

    public Category(String mName, int mIcon, int mBackgroundColor, int mPrimaryColor) {
        this.mName = mName;
        this.mIcon = mIcon;
        this.mBackgroundColor = mBackgroundColor;
        this.mPrimaryColor = mPrimaryColor;
    }

    private int mPrimaryColor;

    public String getName() {
        return mName;
    }


    public int getIcon() {
        return mIcon;
    }


    public int getBackgroundColor() {
        return mBackgroundColor;
    }


    public int getPrimaryColor() {
        return mPrimaryColor;
    }


}
