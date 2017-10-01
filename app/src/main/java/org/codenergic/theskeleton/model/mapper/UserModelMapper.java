package org.codenergic.theskeleton.model.mapper;

import org.codenergic.theskeleton.domain.user.User;
import org.codenergic.theskeleton.model.UserModel;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by putrice on 10/1/17.
 */
@Singleton
public class UserModelMapper {

    @Inject
    public UserModelMapper() {
    }

    public UserModel transform(User user) {
        UserModel userModel = null;

        if (user != null) {
            userModel = new UserModel();
            userModel.setEmail(user.getEmail());
            userModel.setId(user.getId());
            userModel.setUsername(user.getUsername());
        }

        return userModel;
    }

}
