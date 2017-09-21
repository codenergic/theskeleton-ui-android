package org.codenergic.theskeleton.register;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.login.LoginActivity;

import android.content.Intent;

import butterknife.OnClick;

/**
 * Created by putrice on 9/22/17.
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void setup() {

    }

    @OnClick(R.id.link_login)
    public void onLinkLoginClick() {
        navigateToLoginScreen();
    }

    @Override
    public void navigateToLoginScreen() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
