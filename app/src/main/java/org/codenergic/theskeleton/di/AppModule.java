package org.codenergic.theskeleton.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import org.codenergic.theskeleton.data.authentication.repository.AuthenticationEntityRepository;
import org.codenergic.theskeleton.data.user.repository.UserEntityRepository;
import org.codenergic.theskeleton.domain.authentication.repository.AuthenticationRepository;
import org.codenergic.theskeleton.domain.user.repository.UserRepository;

import javax.inject.Singleton;

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
    AuthenticationRepository providesAuthenticationRepository(
        AuthenticationEntityRepository authenticationEntityRepository) {
        return authenticationEntityRepository;
    }

    @Provides
    @Singleton
    UserRepository providesUserRepository(UserEntityRepository userEntityRepository) {
        return userEntityRepository;
    }

}
