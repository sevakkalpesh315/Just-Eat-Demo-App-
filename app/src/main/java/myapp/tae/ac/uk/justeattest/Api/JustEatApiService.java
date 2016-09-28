package myapp.tae.ac.uk.justeattest.Api;


import myapp.tae.ac.uk.justeattest.Constants.Constants;
import myapp.tae.ac.uk.justeattest.Model.JustEat;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Kalpesh on 20/06/2016.
 */
public interface JustEatApiService {

    @Headers({
            "Accept-Tenant: uk",
            "Accept-Language: en-GB",
            "Authorization: Basic VGVjaFRlc3RBUEk6dXNlcjI=",
            "Host: public.je-apis.com"

    })
    @GET(Constants.DATA_TO_FETCH)
    Observable<JustEat> getResult(@Query("q") String location);
}
