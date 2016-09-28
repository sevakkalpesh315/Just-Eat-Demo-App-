package myapp.tae.ac.uk.justeattest;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myapp.tae.ac.uk.justeattest.Constants.Constants;
import myapp.tae.ac.uk.justeattest.DI.components.APIComponent;
import myapp.tae.ac.uk.justeattest.Interfaces.JustEatView;
import myapp.tae.ac.uk.justeattest.Model.Restaurant;
import myapp.tae.ac.uk.justeattest.Presenters.JustEatPresenter;
import myapp.tae.ac.uk.justeattest.UI.RestaurantResultActivity;
import myapp.tae.ac.uk.justeattest.Util.RxUtils;
import myapp.tae.ac.uk.justeattest.Util.ServiceUtil;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity implements JustEatView {
    @Bind(R.id.etSearch)
    EditText etSearch;

    @Bind(R.id.ivGPS)
    ImageView ivGps;

    @Bind(R.id.prGPSProgress)
    ProgressBar prGpsLoad;

    @Bind(R.id.btSearch)
    Button btSearch;

    @Bind(R.id.cbFilterFreeDel)
    CheckBox cbFilterFreeDelivery;

    @Bind(R.id.cbFilterFoodHala)
    CheckBox cbFilterFoodHalal;

    @Bind(R.id.rbFilterRating)
    RatingBar rbFilterRating;

    private JustEatPresenter presenter;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();
    private LocationManager lm = null;
    private LocationListener locationListener;
    private ProgressDialog progressDialog;
    private List<Restaurant> restaurants = null;
    private boolean isFilterOn = false;
    private boolean isHalalChecked = false;
    private boolean isFreeDeliveryChecked = false;
    private float filterRating = -1;
    private long lastDataAcquiredTime = 0;
    private String lastPostCode = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        presenter = new JustEatPresenter(this);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        setInjections();
        setListeners();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data ...");

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setInjections() {
        ButterKnife.bind(this);
        APIComponent apiComponent = ((MyApplication)getApplication()).getApiComponent();
        presenter.injectForData(apiComponent);
    }

    private void setListeners() {
        configureFilterViews();
        configureLocationViews();
    }

    private void configureFilterViews() {
        CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.cbFilterFreeDel:
                        isFreeDeliveryChecked = isChecked;
                        if (!isFilterOn)
                            isFilterOn = !isFilterOn;
                        break;
                    case R.id.cbFilterFoodHala:
                        isHalalChecked = isChecked;
                        if (!isFilterOn)
                            isFilterOn = !isFilterOn;
                        break;
                    default:
                }
            }
        };

        RatingBar.OnRatingBarChangeListener ratingBarChangeListener = new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                filterRating = (int) rating;
                if (!isFilterOn)
                    isFilterOn = !isFilterOn;
            }
        };

        cbFilterFreeDelivery.setOnCheckedChangeListener(checkListener);
        cbFilterFoodHalal.setOnCheckedChangeListener(checkListener);
        rbFilterRating.setOnRatingBarChangeListener(ratingBarChangeListener);
    }

    private void configureLocationViews() {
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
               setPostCodeToSearchBarFromLocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.ivGPS) {
                    prGpsLoad.setVisibility(View.VISIBLE);
                    configureGPS(locationListener);
                }
            }
        };
        ivGps.setOnClickListener(onClickListener);
    }

    private void setPostCodeToSearchBarFromLocation(Location location) {
        try {
            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 3);
            for (int i = 0; i < addresses.size(); i++) {
                String postCode = addresses.get(i).getPostalCode();
                if(postCode.matches(Constants.POSTCODE_FORMAT)) {
                    etSearch.setText(postCode);
                    break;
                }
            }
            prGpsLoad.setVisibility(View.GONE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void configureGPS(LocationListener locationListener) {
        if (ServiceUtil.isLocationPermissionsGranted(MainActivity.this)) {
            String[] permissions = {
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            };

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions, Constants.LOCATION_PERMISSIONS);
            }
            return;
        }
        requestLocationUpdate();
    }

    private void requestLocationUpdate() {
        lm.requestLocationUpdates("gps", 5000, 10, locationListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState==null)
            return;
        restaurants = savedInstanceState.getParcelableArrayList(Constants.RESTAURANT_LIST);
        boolean[] filterBoolRecord = savedInstanceState.getBooleanArray(Constants.FILTER_DATA_BOOLEAN);
        isFilterOn = filterBoolRecord[0];
        isFreeDeliveryChecked = filterBoolRecord[1];
        isHalalChecked = filterBoolRecord[2];
        filterRating = savedInstanceState.getInt(Constants.FILTER_DATA_RATING);
        lastDataAcquiredTime = savedInstanceState.getLong(Constants.SEARCH_HISTORY_TIME);
        lastPostCode = savedInstanceState.getString(Constants.SEARCH_HISTORY_POSTCODE);

        cbFilterFreeDelivery.setChecked(isFreeDeliveryChecked);
        cbFilterFoodHalal.setChecked(isHalalChecked);
        if(filterRating<0)
            rbFilterRating.setRating(filterRating);
        if(!lastPostCode.isEmpty())
            etSearch.setText(lastPostCode);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(Constants.RESTAURANT_LIST, (ArrayList<? extends Parcelable>) restaurants);
        outState.putBooleanArray(Constants.FILTER_DATA_BOOLEAN, new boolean[]{isFilterOn, isFreeDeliveryChecked, isHalalChecked});
        outState.putFloat(Constants.FILTER_DATA_RATING,filterRating);
        outState.putLong(Constants.SEARCH_HISTORY_TIME, lastDataAcquiredTime);
        outState.putString(Constants.SEARCH_HISTORY_POSTCODE, lastPostCode);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        compositeSubscription = RxUtils.getNewCompositeSubIfUnsubscribe(compositeSubscription);
    }

    @Override
    protected void onPause() {
        super.onPause();
        RxUtils.unsubscribeIfNotNull(compositeSubscription);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case Constants.LOCATION_PERMISSIONS:
                if(permissions.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    requestLocationUpdate();
                }
        }

    }

    @Override
    public void updateRestaurantList(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        if(restaurants==null|| restaurants.size()==0){
            Snackbar.make(btSearch, getString(R.string.error_no_data), Snackbar.LENGTH_LONG).show();
            return;
        }
        filterOrDisplayLastUpdatedData();
    }

    @Override
    public void filterOrDisplayLastUpdatedData() {
        List<Restaurant> filteredRestaurants = new ArrayList<>();
        if(isFilterOn){
            filteredRestaurants = presenter.filterData(isFreeDeliveryChecked, isHalalChecked, filterRating);
        }else{
            filteredRestaurants = restaurants;
        }
        startRestaurantListActivity(filteredRestaurants);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public void showRxError(int resId) {
        Snackbar.make(btSearch, getString(resId), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public String getSearchPostCode() {
        return etSearch.getText().toString();
    }

    @Override
    public void showEmptyPostCodeError(int resId) {
        etSearch.setError(getString(resId));
    }

    @Override
    public void showPostCodeFormatError(int resId) {
        etSearch.setError(getString(resId));
    }

    @Override
    public String getPreviousSearchPostCode() {
        return lastPostCode;
    }

    @Override
    public void showProgressDialog(){
        if(!progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void stopProgressDialog(){
        if(progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public long getLastDataAcquiredTime() {
        return lastDataAcquiredTime;
    }

    @Override
    public void setLastDataAcquiredTime(long lastDataAcquiredTime) {
        this.lastDataAcquiredTime = lastDataAcquiredTime;
    }

    @Override
    public String getSearchText() {
        return etSearch.getText().toString();
    }

    @Override
    public void setLastPostCode(String postCode) {
        this.lastPostCode = postCode;
    }

    @OnClick(R.id.btSearch)
    public void onSearchButtonClicked(View v){
        Subscription subscription = presenter.onSearchButtonClicked();
        if(subscription!=null)
            compositeSubscription.add(subscription);
    }

    private void startRestaurantListActivity(List<Restaurant> restaurantsList) {
        Intent intent = new Intent(this, RestaurantResultActivity.class);
        intent.putParcelableArrayListExtra(Constants.RESTAURANT_LIST, (ArrayList<? extends Parcelable>) restaurantsList);
        startActivity(intent);
    }
}
