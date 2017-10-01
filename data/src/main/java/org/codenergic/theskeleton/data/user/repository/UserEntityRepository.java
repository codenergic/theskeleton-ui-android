package org.codenergic.theskeleton.data.user.repository;

import org.codenergic.theskeleton.data.user.mapper.UserEntityMapper;
import org.codenergic.theskeleton.data.user.repository.source.UserEntityDataFactory;
import org.codenergic.theskeleton.domain.user.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by putrice on 10/1/17.
 */

public class UserEntityRepository implements UserRepository {

    private final UserEntityDataFactory userEntityDataFactory;

    private final UserEntityMapper userEntityMapper;

    @Inject
    public UserEntityRepository(UserEntityDataFactory userEntityDataFactory,
        UserEntityMapper userEntityMapper) {
        this.userEntityDataFactory = userEntityDataFactory;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public Flowable<Boolean> login(String username, String password) {
        return userEntityDataFactory.createData().login(username, password);
    }
}
