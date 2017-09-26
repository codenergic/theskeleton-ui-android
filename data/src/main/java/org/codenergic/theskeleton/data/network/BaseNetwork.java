package org.codenergic.theskeleton.data.network;

import org.codenergic.theskeleton.data.helper.RxTransformer;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by putrice on 9/27/17.
 */

public abstract class BaseNetwork<T> {

    @Inject
    public RxTransformer rxTransformer;

    @Inject
    Retrofit.Builder retrofitBuilder;

    private T networkService;

    public T getNetworkService() {
        if (networkService == null) {
            initNetworkInterface();
        }
        return networkService;
    }

    private void initNetworkInterface() {
        networkService = retrofitBuilder
            .baseUrl(getBaseUrl())
            .build()
            .create(getRestClass());
    }

    protected abstract String getBaseUrl();

    protected abstract Class<T> getRestClass();

}
