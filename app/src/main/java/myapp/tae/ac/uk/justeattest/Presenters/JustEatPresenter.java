package myapp.tae.ac.uk.justeattest.Presenters;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import myapp.tae.ac.uk.justeattest.Constants.Constants;
import myapp.tae.ac.uk.justeattest.DI.components.APIComponent;
import myapp.tae.ac.uk.justeattest.Interfaces.DataServiceInterface;
import myapp.tae.ac.uk.justeattest.Interfaces.JustEatView;
import myapp.tae.ac.uk.justeattest.Model.Restaurant;
import myapp.tae.ac.uk.justeattest.R;
import rx.Subscription;

/**
 * Created by Kalpesh on 20/06/16.
 */
public class JustEatPresenter implements Observer {

    private final JustEatView view;
    private final DataServiceInterface dataService;

    public JustEatPresenter(JustEatView view){
        this.view = view;
        this.dataService = new DataService();
        dataService.addObserverInObservable(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        view.stopProgressDialog();
        if(Constants.RESTAURANT_DATA_FETCHED==(int) data){
            List<Restaurant> restaurants = dataService.getRestaurants();
            if(restaurants!=null){
                view.updateRestaurantList(restaurants);
            }
        }else if(Constants.DATA_FETCH_ERROR==(int) data){
            view.showRxError(R.string.error_rx);
        }
    }

    public void injectForData(APIComponent apiComponent) {
        dataService.initiateInjectionGraph(apiComponent);
    }


    public Subscription onSearchButtonClicked() {
        String postCode = view.getSearchPostCode();
        if(postCode.isEmpty()){
            view.showEmptyPostCodeError(R.string.error_search_empty);
            return null;
        }
        if(!postCode.matches(Constants.POSTCODE_FORMAT)){
            view.showPostCodeFormatError(R.string.error_search_format);
            return null;
        }

        String oldPostCode = view.getPreviousSearchPostCode();
        if(oldPostCode.equalsIgnoreCase(postCode)){
            long timePassedSinceLastSearch = getSearchTimeDifference();
            if(timePassedSinceLastSearch<=1000*60*5 && view.getRestaurants()!=null&&view.getRestaurants().size()>0){//less than five minutes time passed
                view.filterOrDisplayLastUpdatedData();
                return null;
            }
        }

        view.setLastPostCode(postCode);
        view.showProgressDialog();
        return dataService.getRestaurantsByPostCode(postCode);

    }

    private long getSearchTimeDifference() {
        long lastDataAcquiredTime = view.getLastDataAcquiredTime();
        if(lastDataAcquiredTime==0){
            lastDataAcquiredTime = SystemClock.currentThreadTimeMillis();
            return 0;
        }
        long currentTime = SystemClock.currentThreadTimeMillis();
        long difference = currentTime-lastDataAcquiredTime;
        lastDataAcquiredTime = currentTime;
        view.setLastDataAcquiredTime(lastDataAcquiredTime);
        return difference;
    }

    public List<Restaurant> filterData(boolean isFreeDeliveryChecked, boolean isHalalChecked, float filterRating) {
        List<Restaurant> filteredRestaurant = new ArrayList<>();
        List<Restaurant> dataToFilter = view.getRestaurants();
        for (int i = 0; i < dataToFilter.size(); i++) {
            Restaurant restaurant = dataToFilter.get(i);
            if (isFreeDeliveryChecked)
                if (restaurant.getDeliveryCost()!=null && restaurant.getDeliveryCost() > 0)
                    continue;
            if (isHalalChecked)
                if (!restaurant.getIsHalal())
                    continue;
            if (filterRating >0)
                if(restaurant.getRatingStars() < filterRating)
                continue;
            filteredRestaurant.add(restaurant);

        }
        return filteredRestaurant;
    }
}
