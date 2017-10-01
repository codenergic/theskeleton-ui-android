package org.codenergic.theskeleton.domain.user.repository;

import io.reactivex.Flowable;

/**
 * Created by putrice on 10/1/17.
 */

public interface UserRepository {

    Flowable<Boolean> login(String username, String password);

}
