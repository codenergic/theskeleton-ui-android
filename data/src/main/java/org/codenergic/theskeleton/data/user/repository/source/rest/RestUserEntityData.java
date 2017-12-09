package org.codenergic.theskeleton.data.user.repository.source.rest;

import org.codenergic.theskeleton.data.helper.RxTransformer;
import org.codenergic.theskeleton.data.user.UserEntity;
import org.codenergic.theskeleton.data.user.repository.source.UserData;
import org.codenergic.theskeleton.data.user.repository.source.request.SignUpRequest;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class RestUserEntityData implements UserData{

    private UserApi userApi;

    @Inject
    public RestUserEntityData(UserApi userApi) {
        this.userApi = userApi;
    }

    @Override
    public Flowable<UserEntity> signUp(SignUpRequest signUpRequest) {
        return userApi.signUp(signUpRequest)
            .compose(RxTransformer.applyThreadTransformer());
    }
}
