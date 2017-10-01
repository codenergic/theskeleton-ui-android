package org.codenergic.theskeleton.login;

import org.codenergic.theskeleton.domain.DefaultSubscriber;
import org.codenergic.theskeleton.domain.user.User;
import org.codenergic.theskeleton.domain.user.interactor.Login;
import org.codenergic.theskeleton.model.mapper.UserModelMapper;

import javax.inject.Inject;

/**
 * Created by putrice on 10/1/17.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private final Login login;

    private final UserModelMapper userModelMapper;

    private final LoginContract.View view;

    @Inject
    public LoginPresenter(LoginContract.View view, Login login, UserModelMapper userModelMapper) {
        this.view = view;
        this.login = login;
        this.userModelMapper = userModelMapper;
    }

    @Override
    public void login(String username, String password) {
        login.execute(new DefaultSubscriber<Boolean>() {
            @Override
            public void onNext(Boolean success) {
                view.onLoginSuccess();
            }

            @Override
            public void onError(Throwable t) {
                view.onLoginFailed(t.getMessage());
            }
        }, Login.Params.forLogin(username, password));
    }
}
