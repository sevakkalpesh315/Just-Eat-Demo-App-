package myapp.tae.ac.uk.justeattest.Interfaces;

import java.util.List;

import myapp.tae.ac.uk.justeattest.Model.Restaurant;

/**
 * Created by Kalpesh on 20/06/16.
 */
public interface JustEatView {
    void updateRestaurantList(List<Restaurant> restaurants);

    String getSearchPostCode();

    void showEmptyPostCodeError(int resId);

    void showPostCodeFormatError(int resId);

    String getPreviousSearchPostCode();

    void filterOrDisplayLastUpdatedData();

    List<Restaurant> getRestaurants();

    void showRxError(int resId);

    void showProgressDialog();

    void stopProgressDialog();

    long getLastDataAcquiredTime();

    void setLastDataAcquiredTime(long lastDataAcquiredTime);

    String getSearchText();

    void setLastPostCode(String postCode);
}
