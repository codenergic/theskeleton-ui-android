package org.codenergic.theskeleton.domain.user.repository;

import org.codenergic.theskeleton.domain.user.User;

import io.reactivex.Flowable;

public interface UserRepository {

    Flowable<User> signUp(String username, String password, String email);

    Flowable<User> getProfileUser();

    Flowable<User> getCurrentUser();

}
