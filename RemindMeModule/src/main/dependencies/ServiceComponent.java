package dependencies;

import activity.GetTaskActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetTaskActivity provideGetTaskActivity();
}
