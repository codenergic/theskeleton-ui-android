package org.codenergic.theskeleton.base.auth;

import org.codenergic.theskeleton.model.UserModel;

/**
 * Created by putrice on 2/1/18.
 */
public interface BaseAuthContract {

    interface View {

        void onAuthorized(UserModel userModel);

        void onUnauthorized();

    }

    interface Presenter {

        void checkUserLogin();
    }

}
