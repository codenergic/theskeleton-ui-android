package org.codenergic.theskeleton.register;

import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.domain.DefaultSubscriber;
import org.codenergic.theskeleton.domain.user.User;
import org.codenergic.theskeleton.domain.user.interactor.SignUp;

import javax.inject.Inject;

public class RegisterPresenter extends BasePresenter implements RegisterContract.Presenter {

    private final SignUp signUp;

    private final RegisterContract.View view;

    @Inject
    public RegisterPresenter(RegisterContract.View view, SignUp signUp) {
        this.signUp = signUp;
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {
        signUp.clearAllSubscription();
    }

    @Override
    public void signUp(String username, String password, String email) {
        signUp.execute(new DefaultSubscriber<User>() {
            @Override
            public void onNext(User user) {
                view.onSignUpSuccess();
            }

            @Override
            public void onError(Throwable t) {
                view.onSignUpFailed(t.getMessage());
            }
        }, new SignUp.Params(username, password, email));
    }
}
