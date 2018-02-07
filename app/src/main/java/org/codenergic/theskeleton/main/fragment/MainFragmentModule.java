package org.codenergic.theskeleton.main.fragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diasa on 2/7/18.
 */
@Module
public class MainFragmentModule {

    @Provides
    MainFragmentContract.View provideMainFragmentView(MainFragment mainFragment) {
        return mainFragment;
    }

    @Provides
    MainFragmentContract.Presenter provideMainFragmentPresenter(
        MainFragmentPresenter mainFragmentPresenter) {
        return mainFragmentPresenter;
    }
}
