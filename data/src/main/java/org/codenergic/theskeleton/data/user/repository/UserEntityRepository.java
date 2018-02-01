package org.codenergic.theskeleton.data.user.repository;

import org.codenergic.theskeleton.data.user.UserEntity;
import org.codenergic.theskeleton.data.user.repository.source.UserDataFactory;
import org.codenergic.theskeleton.data.user.repository.source.local.UserPreferences;
import org.codenergic.theskeleton.data.user.repository.source.request.SignUpRequest;
import org.codenergic.theskeleton.domain.user.User;
import org.codenergic.theskeleton.domain.user.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class UserEntityRepository implements UserRepository {

    private final UserDataFactory userDataFactory;

    private final UserPreferences userPreferences;

    @Inject
    public UserEntityRepository(UserDataFactory userDataFactory, UserPreferences userPreferences) {
        this.userDataFactory = userDataFactory;
        this.userPreferences = userPreferences;
    }

    @Override
    public Flowable<User> signUp(String username, String password, String email) {
        SignUpRequest signUpRequest = new SignUpRequest(username, password, email);
        return userDataFactory.createData().signUp(signUpRequest)
            .map(UserEntity::toUser);
    }

    @Override
    public Flowable<User> getProfileUser() {
        return userDataFactory.createData().getUserProfile()
            .map(userEntity -> {
                userPreferences.saveUser(userEntity);
                return userEntity.toUser();
            });
    }

    @Override
    public Flowable<User> getCurrentUser() {
        return Flowable.just(userPreferences.getUser().toUser());
    }
}
