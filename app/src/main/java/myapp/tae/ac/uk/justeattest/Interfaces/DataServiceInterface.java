package myapp.tae.ac.uk.justeattest.Interfaces;

import java.util.List;
import java.util.Observer;

import myapp.tae.ac.uk.justeattest.DI.components.APIComponent;
import myapp.tae.ac.uk.justeattest.Model.JustEat;
import myapp.tae.ac.uk.justeattest.Model.Restaurant;
import rx.Observable;
import rx.Subscription;

/**
 * Created by Kalpesh on 20/06/16..
 */
public interface DataServiceInterface {

    public void initiateInjectionGraph(APIComponent apiComponent);


    public List<Restaurant> getRestaurants();

    public void addObserverInObservable(Observer observer);

    public Observable<JustEat> getJustEatStream(String postCode);

    public Observable getJustEatRestaurants(Observable justEatObservable);

    public Subscription getRestaurantsByPostCode(String postCode);

}
