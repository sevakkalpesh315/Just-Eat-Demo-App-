package myapp.tae.ac.uk.justeattest.DI.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kalpesh on 20/06/16..
 */
@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }
}
