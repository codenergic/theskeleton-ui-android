package org.codenergic.theskeleton.domain.authentication;

import io.reactivex.Flowable;

public interface AuthenticationRepository {
    Flowable<Authentication> authenticate(String username, String password);
}
