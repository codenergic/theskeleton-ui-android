package org.codenergic.theskeleton.di;

import org.codenergic.theskeleton.TheSkeletonApplication;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by putrice on 9/25/17.
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        ActivityBuilder.class
})
public interface AppComponent {

    void inject(TheSkeletonApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
