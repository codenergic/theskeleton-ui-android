package org.codenergic.theskeleton.di;

import org.codenergic.theskeleton.data.user.repository.UserEntityRepository;
import org.codenergic.theskeleton.domain.user.repository.UserRepository;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by putrice on 9/25/17.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserEntityRepository userEntityRepository) {
        return userEntityRepository;
    }

}
