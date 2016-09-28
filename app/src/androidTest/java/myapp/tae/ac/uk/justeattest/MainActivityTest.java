package myapp.tae.ac.uk.justeattest;


import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.robotium.solo.Condition;
import com.robotium.solo.Solo;

import myapp.tae.ac.uk.justeattest.UI.RestaurantResultActivity;

/**
 * Created by Kalpesh on 21/06/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;
    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "myapp.tae.ac.uk.justeattest.MainActivity";
    private static final Class<?> launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public MainActivityTest() {
        super(launcherActivityClass);;
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testBasicJustEatSearch() throws Exception {
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        EditText etSearch = (EditText) solo.getView(R.id.etSearch);
        Button btSearch = (Button) solo.getView(R.id.btSearch);
        CheckBox cbFilterDeliveryFree = (CheckBox) solo.getView(R.id.cbFilterFreeDel);
        CheckBox cbFilterHalalFood = (CheckBox) solo.getView(R.id.cbFilterFoodHala);
        RatingBar ratingBar = (RatingBar) solo.getView(R.id.rbFilterRating);
        solo.sleep(3000);
        solo.clickOnView(etSearch);
        solo.enterText(etSearch, "123934");
        assertTrue(solo.waitForText("123934"));
        solo.sleep(2000);
        solo.clickOnView(btSearch);
        solo.sleep(3000);
        solo.clickOnView(etSearch);
        solo.clearEditText(etSearch);
        solo.sleep(2000);
        solo.typeText(etSearch, "E6 2JX");
        solo.waitForText("E6 2JX");
        solo.sleep(2000);
        solo.clickOnView(cbFilterHalalFood);
        solo.sleep(2000);
        solo.clickOnView(cbFilterDeliveryFree);
        solo.sleep(2000);
        solo.setProgressBar(ratingBar,5);
        solo.sleep(2000);
        solo.clickOnView(btSearch);
        solo.sleep(200);
        if(solo.waitForActivity(RestaurantResultActivity.class)) {
            solo.scrollRecyclerViewToBottom(0);
            solo.goBack();
        }

    }

    public void testGPS() throws Exception {
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        ImageView ivGps = (ImageView) solo.getView(R.id.ivGPS);
        Button btSearch = (Button) solo.getView(R.id.btSearch);
        final EditText etSearch = (EditText) solo.getView(R.id.etSearch);
        solo.clickOnView(ivGps);
        solo.waitForCondition(new Condition() {
            @Override
            public boolean isSatisfied() {
                return !etSearch.getText().toString().isEmpty();
            }
        },10000);
        solo.clickOnView(btSearch);
        if(solo.waitForActivity(RestaurantResultActivity.class)) {
            solo.scrollRecyclerViewToBottom(0);
            solo.clickInRecyclerView(3);
            solo.sleep(2000);
            solo.goBack();
        }
    }
}