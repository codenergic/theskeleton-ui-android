package org.codenergic.theskeleton.main;

import org.codenergic.theskeleton.main.fragment.MainFragment;
import org.codenergic.theskeleton.main.fragment.MainFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by diasa on 2/7/18.
 */
@Module
public abstract class MainFragmentProvider {

    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment provideMainFragmentFactory();
}
