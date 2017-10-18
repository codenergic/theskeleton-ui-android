package org.codenergic.theskeleton.login;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.register.RegisterActivity;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import timber.log.Timber;

/**
 * Created by putrice on 9/22/17.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.input_email)
    EditText etEmail;

    @BindView(R.id.input_password)
    EditText etPassword;

    @Inject
    LoginContract.Presenter presenter;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
    }

    @OnClick(R.id.btn_login)
    public void onButtonSubmitClick() {
        presenter.login(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @OnClick(R.id.link_signup)
    public void onLinkSignUpClick() {
        navigateToRegisterScreen();
    }

    public void navigateToRegisterScreen() {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    @Override
    public void onLoginSuccess() {
        //TODO handle when login success
        Toast.makeText(this, "Login succeed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginFailed(String errorMessage) {
        //TODO using proper error message
        Timber.e(errorMessage);
        Toast.makeText(this, "Login error: " + errorMessage, Toast.LENGTH_LONG).show();
    }
}
