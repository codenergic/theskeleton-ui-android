package org.codenergic.theskeleton.data.user.repository.source;

import io.reactivex.Flowable;

/**
 * Created by putrice on 10/1/17.
 */

public interface UserEntityData {

    Flowable<Boolean> login(String username, String password);

}
