package org.codenergic.theskeleton.main;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diasa on 2/10/18.
 */
@Module
public class MainModule {

    @Provides
    MainContract.View provideMainActivity(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    MainContract.Presenter provideMainPresenter(MainPresenter mainPresenter) {
        return mainPresenter;
    }
}