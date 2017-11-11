package org.codenergic.theskeleton.domain.authentication.repository;

import org.codenergic.theskeleton.domain.authentication.Authentication;

import io.reactivex.Flowable;

public interface AuthenticationRepository {

    Flowable<Authentication> authenticate(String username, String password);

}
