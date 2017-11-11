package org.codenergic.theskeleton.data.authentication.repository.source;

import org.codenergic.theskeleton.data.authentication.AuthenticationEntity;

import io.reactivex.Flowable;

public interface AuthenticationData {

    Flowable<AuthenticationEntity> authenticate(String username, String password);

}
