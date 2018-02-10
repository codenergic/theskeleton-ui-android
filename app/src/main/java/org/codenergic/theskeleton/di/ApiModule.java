package org.codenergic.theskeleton.di;

import org.codenergic.theskeleton.data.authentication.repository.source.rest.AuthenticationApi;
import org.codenergic.theskeleton.data.post.repository.source.rest.PostApi;
import org.codenergic.theskeleton.data.user.repository.source.rest.UserApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    AuthenticationApi provideAppVersionApi(Retrofit retrofit) {
        return retrofit.create(AuthenticationApi.class);
    }

    @Provides
    @Singleton
    UserApi provideUserApi(Retrofit retrofit) {
        return retrofit.create(UserApi.class);
    }

    @Provides
    @Singleton
    PostApi providePostApi(Retrofit retrofit) {
        return retrofit.create(PostApi.class);
    }
}