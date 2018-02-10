package org.codenergic.theskeleton.login;

import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.domain.DefaultSubscriber;
import org.codenergic.theskeleton.domain.authentication.Authentication;
import org.codenergic.theskeleton.domain.authentication.interactor.Authenticate;
import org.codenergic.theskeleton.domain.user.User;
import org.codenergic.theskeleton.domain.user.interactor.GetUserProfile;

import javax.inject.Inject;

/**
 * Created by putrice on 10/1/17.
 */

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {

    private final Authenticate authenticate;

    private final GetUserProfile getUserProfile;

    private final LoginContract.View view;

    @Inject
    public LoginPresenter(LoginContract.View view,
        Authenticate authenticate,
        GetUserProfile getUserProfile) {
        this.view = view;
        this.authenticate = authenticate;
        this.getUserProfile = getUserProfile;
    }

    @Override
    public void login(String username, String password) {
        authenticate.execute(new DefaultSubscriber<Authentication>() {
            @Override
            public void onNext(Authentication authentication) {
                getUserProfile();
            }

            @Override
            public void onError(Throwable t) {
                view.onLoginFailed(t.getMessage());
            }
        }, new Authenticate.Params(username, password));
    }

    private void getUserProfile() {
        getUserProfile.execute(new DefaultSubscriber<User>() {
            @Override
            public void onNext(User user) {
                view.onLoginSuccess();
            }

            @Override
            public void onError(Throwable t) {
                view.onLoginFailed(t.getMessage());
            }
        });
    }

    @Override
    protected void onViewDestroy() {
        authenticate.clearAllSubscription();
        getUserProfile.clearAllSubscription();
    }
}
