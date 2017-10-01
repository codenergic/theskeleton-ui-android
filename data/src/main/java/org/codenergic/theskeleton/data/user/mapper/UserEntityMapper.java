package org.codenergic.theskeleton.data.user.mapper;

import org.codenergic.theskeleton.data.user.UserEntity;
import org.codenergic.theskeleton.domain.user.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by putrice on 10/1/17.
 */
@Singleton
public class UserEntityMapper {

    @Inject
    public UserEntityMapper() {
    }

    public UserEntity transform(User user) {
        UserEntity userEntity = null;

        if (user != null) {
            userEntity = new UserEntity();
            userEntity.setEmail(user.getEmail());
            userEntity.setId(user.getId());
            userEntity.setUsername(user.getUsername());
        }

        return userEntity;
    }

    public User transform(UserEntity userEntity) {
        User user = null;

        if (userEntity != null) {
            user.setEmail(userEntity.getEmail());
            user.setId(userEntity.getId());
            user.setUsername(userEntity.getUsername());
        }

        return user;
    }

}
