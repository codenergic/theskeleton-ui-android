package org.codenergic.theskeleton.base.auth;

import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.domain.DefaultSubscriber;
import org.codenergic.theskeleton.domain.user.User;
import org.codenergic.theskeleton.domain.user.interactor.GetCurrentUser;
import org.codenergic.theskeleton.model.UserModel;

import javax.inject.Inject;

/**
 * Created by putrice on 2/1/18.
 */
public class BaseAuthPresenter extends BasePresenter implements
    BaseAuthContract.Presenter {

    private final GetCurrentUser getCurrentUser;

    private BaseAuthContract.View view;

    @Inject
    public BaseAuthPresenter(GetCurrentUser getCurrentUser) {
        this.getCurrentUser = getCurrentUser;
    }

    public void setView(BaseAuthContract.View view) {
        this.view = view;
    }

    @Override
    public void checkUserLogin() {
        getCurrentUser.execute(new DefaultSubscriber<User>() {
            @Override
            public void onNext(User user) {
                //TODO need to change with proper checking
                if (user.getEmail() != null) {
                    view.onAuthorized(new UserModel());
                } else {
                    view.onUnauthorized();
                }
            }

            @Override
            public void onError(Throwable t) {
                view.onUnauthorized();
            }
        });
    }

    @Override
    protected void onViewDestroy() {
        getCurrentUser.clearAllSubscription();
    }

}
