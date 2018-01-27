package org.codenergic.theskeleton.profile;

import org.codenergic.theskeleton.base.BasePresenter;

import javax.inject.Inject;

public class ProfilePresenter extends BasePresenter implements ProfileContract.Presenter {

    @Inject
    public ProfilePresenter() {

    }

    @Override
    protected void onViewDestroy() {

    }
}
