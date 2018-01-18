package org.codenergic.theskeleton.main;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diasa on 11/8/17.
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
