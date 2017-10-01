package org.codenergic.theskeleton.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.codenergic.theskeleton.data.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by putrice on 9/27/17.
 */

public abstract class BaseNetwork<T> {

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ssZ";

    private T networkService;

    public T getNetworkService() {
        if (networkService == null) {
            initNetworkInterface();
        }
        return networkService;
    }

    private void initNetworkInterface() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(new AuthInterceptor())
            .build();

        Gson gson = new GsonBuilder().setPrettyPrinting()
            .setDateFormat(DATE_FORMAT)
            .create();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(getBaseUrl());

        Retrofit retrofit = retrofitBuilder
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build();

        networkService = retrofit.create(getRestClass());

    }

    protected abstract String getBaseUrl();

    protected abstract Class<T> getRestClass();

}
