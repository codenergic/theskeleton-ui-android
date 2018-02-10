package org.codenergic.theskeleton.base.auth;

import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.login.LoginActivity;

import android.content.Intent;

import javax.inject.Inject;

/**
 * Created by putrice on 2/1/18.
 */
public abstract class BaseAuthActivity extends BaseActivity implements BaseAuthContract.View {

    @Inject
    BaseAuthPresenter presenter;

    @Override
    protected void onDestroy() {
        presenter.onViewDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.checkUserLogin();
    }

    @Override
    public void onUnauthorized() {
        navigateToAuth();
    }

    private void navigateToAuth() {
        startActivity(new Intent(this, LoginActivity.class));
    }

}
