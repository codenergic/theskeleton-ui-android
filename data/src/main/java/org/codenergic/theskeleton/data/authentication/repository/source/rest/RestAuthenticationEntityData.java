package org.codenergic.theskeleton.data.authentication.repository.source.rest;

import org.codenergic.theskeleton.data.authentication.AuthenticationEntity;
import org.codenergic.theskeleton.data.authentication.repository.source.AuthenticationData;
import org.codenergic.theskeleton.data.helper.RxTransformer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class RestAuthenticationEntityData implements AuthenticationData {

    private AuthenticationApi authenticationApi;

    @Inject
    public RestAuthenticationEntityData(AuthenticationApi authenticationApi) {
        this.authenticationApi = authenticationApi;
    }

    @Override
    public Flowable<AuthenticationEntity> authenticate(String username, String password) {
        return authenticationApi.authenticate(username, password)
            .compose(RxTransformer.applyThreadTransformer());
    }
}
