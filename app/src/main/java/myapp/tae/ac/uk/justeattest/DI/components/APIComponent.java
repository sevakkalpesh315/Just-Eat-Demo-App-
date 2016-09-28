package myapp.tae.ac.uk.justeattest.DI.components;

import dagger.Component;
import myapp.tae.ac.uk.justeattest.DI.modules.APIModule;
import myapp.tae.ac.uk.justeattest.DI.scopes.ActivityScope;
import myapp.tae.ac.uk.justeattest.Presenters.DataService;

/**
 * Created by Kalpesh on 20/06/16.
 */
@ActivityScope
@Component(dependencies = NetComponent.class, modules = APIModule.class)
public interface APIComponent {
    void inject(DataService dataService);
}
