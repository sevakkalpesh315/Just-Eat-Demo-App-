package myapp.tae.ac.uk.justeattest.DI.modules;

import dagger.Module;
import dagger.Provides;
import myapp.tae.ac.uk.justeattest.Api.JustEatApiService;
import myapp.tae.ac.uk.justeattest.DI.scopes.ActivityScope;
import retrofit2.Retrofit;

/**
 * Created by Kalpesh on 20/06/16.
 */
@Module
public class APIModule {
    @ActivityScope
    @Provides
    JustEatApiService provideMovieAPI(Retrofit retrofit) {
        return retrofit.create(JustEatApiService.class);
    }
}
