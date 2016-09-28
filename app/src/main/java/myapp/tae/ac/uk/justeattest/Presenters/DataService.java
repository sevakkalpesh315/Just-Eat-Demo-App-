package myapp.tae.ac.uk.justeattest.Presenters;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import javax.inject.Inject;

import myapp.tae.ac.uk.justeattest.Api.JustEatApiService;
import myapp.tae.ac.uk.justeattest.Constants.Constants;
import myapp.tae.ac.uk.justeattest.DI.components.APIComponent;
import myapp.tae.ac.uk.justeattest.Interfaces.DataServiceInterface;
import myapp.tae.ac.uk.justeattest.Model.JustEat;
import myapp.tae.ac.uk.justeattest.Model.Restaurant;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Kalpesh on 20/06/16..
 * The class deals with retrieval of Data from the API and reconfiguration of data to into list of restaurant.
 * It also ensures if the filter is turned on, the filters are performed on flow and notify observers once
 * the data download and filters are completed.
 */
public class DataService extends java.util.Observable implements DataServiceInterface {
    @Inject
    JustEatApiService apiService;
    private List<Restaurant> justEatRestaurants;
    public static final String TAG = DataService.class.getSimpleName();
    public DataService(){
        justEatRestaurants = new ArrayList<>();
    }

    /**
     * The Dagger graph injection is performed in the method.
     * @param apiComponent
     */
    @Override
    public void initiateInjectionGraph(APIComponent apiComponent) {
        apiComponent.inject(this);
    }

    /**
     * The method asynchronously process the retrieval of data and refines to ensure filters are
     * performed if it is enabled.
     * @param postCode
     * @return
     */

    @Override
    public Subscription getRestaurantsByPostCode(String postCode) {


        Observable<List<Restaurant>> justEatRestaurantStream;

        justEatRestaurantStream = getJustEatRestaurants(getJustEatStream(postCode));
        Subscription subscription = justEatRestaurantStream.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Restaurant>>() {
                    @Override
                    public void onCompleted() {
                        setChanged();
                        notifyObservers(Constants.RESTAURANT_DATA_FETCHED);
                    }

                    @Override
                    public void onError(Throwable e) {
                        setChanged();
                        notifyObservers(Constants.DATA_FETCH_ERROR);
                    }

                    @Override
                    public void onNext(List<Restaurant> restaurants) {
                        if(restaurants!=null)
                        justEatRestaurants = restaurants;
                    }
                });
        return subscription;
    }

    /**
     * The method is used to refine the incoming stream and convert to a stream of Restaurant list.
     * @param justEatObservable
     * @return
     */
    @Override
    public Observable getJustEatRestaurants(Observable justEatObservable) {
        justEatObservable = justEatObservable.map(new Func1<JustEat, List<Restaurant>>() {
            @Override
            public List<Restaurant> call(JustEat justEat) {
                return justEat.getRestaurants();
            }
        });
        return justEatObservable;
    }

    @Override
    public Observable<JustEat> getJustEatStream(String postCode) {
        return apiService.getResult(postCode);
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return justEatRestaurants;
    }

    @Override
    public void addObserverInObservable(Observer observer) {
        addObserver(observer);
    }
}
