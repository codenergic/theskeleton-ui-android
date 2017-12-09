package org.codenergic.theskeleton.register;

/**
 * Created by putrice on 9/22/17.
 */

public interface RegisterContract {

    interface View {

        void onSignUpSuccess();

        void onSignUpFailed(String message);

    }

    interface Presenter {

        void signUp(String username, String password, String email);

    }

}
