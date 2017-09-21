package org.codenergic.theskeleton.login;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.register.RegisterActivity;

import android.content.Intent;

import butterknife.OnClick;

/**
 * Created by putrice on 9/22/17.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setup() {

    }

    @OnClick(R.id.link_signup)
    public void onLinkSignUpClick() {
        navigateToRegisterScreen();
    }

    @Override
    public void navigateToRegisterScreen() {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }
}
