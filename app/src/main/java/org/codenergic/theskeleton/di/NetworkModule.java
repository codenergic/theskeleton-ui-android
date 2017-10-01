package org.codenergic.theskeleton.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by putrice on 9/25/17.
 */
@Module
public class NetworkModule {

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ssZ";

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().setPrettyPrinting()
            .setDateFormat(DATE_FORMAT)
            .create();
    }

}
