package myapp.tae.ac.uk.justeattest;

import android.app.Application;

import myapp.tae.ac.uk.justeattest.Constants.Constants;
import myapp.tae.ac.uk.justeattest.DI.components.APIComponent;
import myapp.tae.ac.uk.justeattest.DI.components.DaggerAPIComponent;
import myapp.tae.ac.uk.justeattest.DI.components.DaggerNetComponent;
import myapp.tae.ac.uk.justeattest.DI.components.NetComponent;
import myapp.tae.ac.uk.justeattest.DI.modules.APIModule;
import myapp.tae.ac.uk.justeattest.DI.modules.AppModule;
import myapp.tae.ac.uk.justeattest.DI.modules.NetModule;

/**
 * Created by Kalpesh on 20/06/16..
 */
public class MyApplication extends Application {
    private NetComponent mNetComponent;
    private APIComponent mApiComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .netModule(new NetModule(Constants.BASE_URL))
                .appModule(new AppModule(this))
                .build();

        mApiComponent = DaggerAPIComponent.builder()
                .netComponent(mNetComponent)
                .aPIModule(new APIModule())
                .build();

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public APIComponent getApiComponent() {
        return mApiComponent;
    }
}
