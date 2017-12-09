package org.codenergic.theskeleton.data.user.repository;

import org.codenergic.theskeleton.data.user.UserEntity;
import org.codenergic.theskeleton.data.user.repository.source.UserDataFactory;
import org.codenergic.theskeleton.data.user.repository.source.request.SignUpRequest;
import org.codenergic.theskeleton.domain.user.User;
import org.codenergic.theskeleton.domain.user.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class UserEntityRepository implements UserRepository{

    private final UserDataFactory userDataFactory;

    @Inject
    public UserEntityRepository(UserDataFactory userDataFactory) {
        this.userDataFactory = userDataFactory;
    }

    @Override
    public Flowable<User> signUp(String username, String password, String email) {
        SignUpRequest signUpRequest = new SignUpRequest(username, password, email);
        return userDataFactory.createData().signUp(signUpRequest)
            .map(UserEntity::toUser);
    }
}
