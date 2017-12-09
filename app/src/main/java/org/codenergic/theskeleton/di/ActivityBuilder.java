package org.codenergic.theskeleton.di;

import org.codenergic.theskeleton.login.LoginActivity;
import org.codenergic.theskeleton.login.LoginModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import org.codenergic.theskeleton.main.MainActivity;
import org.codenergic.theskeleton.main.MainModule;
import org.codenergic.theskeleton.register.RegisterActivity;
import org.codenergic.theskeleton.register.RegisterModule;

/**
 * Created by putrice on 9/26/17.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity bindRegisterActivity();
}