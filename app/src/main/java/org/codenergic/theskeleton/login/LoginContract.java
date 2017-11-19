package org.codenergic.theskeleton.login;

/**
 * Created by putrice on 9/22/17.
 */

public interface LoginContract {

    interface View {

        void onLoginSuccess();

        void onLoginFailed(String errorMessage);

    }

    interface Presenter {
        void login(String username, String password);
        void checkSession();
    }
}
