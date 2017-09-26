package org.codenergic.theskeleton.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by putrice on 9/27/17.
 */
@Module
public class LoginActivityModule {

    @Provides
    LoginContract.View provideLogin(LoginActivity loginActivity) {
        return loginActivity;
    }

}
