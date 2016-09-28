package myapp.tae.ac.uk.justeattest.DI.components;

import javax.inject.Singleton;

import dagger.Component;
import myapp.tae.ac.uk.justeattest.DI.modules.AppModule;
import myapp.tae.ac.uk.justeattest.DI.modules.NetModule;
import retrofit2.Retrofit;

/**
 * Created by Kalpesh on 20/06/16.
 */
@Singleton
@Component(modules = {NetModule.class, AppModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
