package org.codenergic.theskeleton.data.user.repository.source.network;

import org.codenergic.theskeleton.data.BuildConfig;
import org.codenergic.theskeleton.data.network.BaseNetwork;
import org.codenergic.theskeleton.data.user.repository.source.UserEntityData;

import javax.inject.Inject;

import io.reactivex.Flowable;

import static org.codenergic.theskeleton.data.helper.RxTransformer.applyThreadTransformer;

/**
 * Created by putrice on 10/1/17.
 */

public class NetworkUserEntityRepository extends BaseNetwork<UserApi> implements UserEntityData {

    @Inject
    public NetworkUserEntityRepository() {
    }

    @Override
    public Flowable<Boolean> login(String username, String password) {
        return getNetworkService()
            .login("password", username, password)
            .map(loginResponse -> !loginResponse.getAccessToken().isEmpty())
            .compose(applyThreadTransformer());
    }

    @Override
    protected String getBaseUrl() {
        return BuildConfig.BASE;
    }

    @Override
    protected Class<UserApi> getRestClass() {
        return UserApi.class;
    }
}
