package org.codenergic.theskeleton.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by putrice on 9/27/17.
 */
@Module
public class LoginModule {

    @Provides
    LoginContract.View provideLoginActivity(LoginActivity loginActivity) {
        return loginActivity;
    }

    @Provides
    LoginContract.Presenter provideLoginPresenter(LoginPresenter loginPresenter) {
        return loginPresenter;
    }

}
