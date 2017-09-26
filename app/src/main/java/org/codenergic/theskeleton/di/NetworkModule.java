package org.codenergic.theskeleton.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.codenergic.theskeleton.BuildConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;

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

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return httpLoggingInterceptor;
    }

}
