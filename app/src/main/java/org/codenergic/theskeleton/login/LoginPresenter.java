package org.codenergic.theskeleton.login;

import org.codenergic.theskeleton.domain.DefaultSubscriber;
import org.codenergic.theskeleton.domain.authentication.Authentication;
import org.codenergic.theskeleton.domain.authentication.interactor.Authenticate;
import org.codenergic.theskeleton.domain.authentication.interactor.SaveAuthentication;

import javax.inject.Inject;

/**
 * Created by putrice on 10/1/17.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private final Authenticate authenticate;
    private final LoginContract.View view;
    private final SaveAuthentication saveAuthentication;

    @Inject
    public LoginPresenter(LoginContract.View view, Authenticate authenticate, SaveAuthentication saveAuthentication) {
        this.view = view;
        this.authenticate = authenticate;
        this.saveAuthentication = saveAuthentication;
    }

    @Override
    public void login(String username, String password) {
        authenticate.execute(new DefaultSubscriber<Authentication>() {
            @Override
            public void onNext(Authentication authentication) {
                saveAuthentication.execute(new DefaultSubscriber<>(), authentication);
                view.onLoginSuccess();
            }

            @Override
            public void onError(Throwable t) {
                view.onLoginFailed(t.getMessage());
            }
        }, new Authenticate.Params(username, password));
    }
}
