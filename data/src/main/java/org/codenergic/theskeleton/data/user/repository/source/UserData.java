package org.codenergic.theskeleton.data.user.repository.source;

import org.codenergic.theskeleton.data.user.UserEntity;
import org.codenergic.theskeleton.data.user.repository.source.request.SignUpRequest;

import io.reactivex.Flowable;

public interface UserData {

    Flowable<UserEntity> signUp(SignUpRequest signUpRequest);

    Flowable<UserEntity> getUserProfile();

}
