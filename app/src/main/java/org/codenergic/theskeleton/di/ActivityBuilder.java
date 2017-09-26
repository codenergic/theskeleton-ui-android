package org.codenergic.theskeleton.di;

import org.codenergic.theskeleton.login.LoginActivity;
import org.codenergic.theskeleton.login.LoginActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by putrice on 9/26/17.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

}