package org.codenergic.theskeleton.register;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.login.LoginActivity;
import org.codenergic.theskeleton.main.MainActivity;

import android.content.Intent;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import timber.log.Timber;

/**
 * Created by putrice on 9/22/17.
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    @BindView(R.id.input_email)
    EditText etEmail;

    @BindView(R.id.input_password)
    EditText etPassword;

    @BindView(R.id.input_name)
    EditText etUsername;

    @Inject
    RegisterPresenter presenter;

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);
    }

    @Override
    public BasePresenter attachPresenter() {
        return presenter;
    }

    @OnClick(R.id.link_login)
    public void onLinkLoginClick() {
        navigateToLogin();
    }

    private void navigateToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.btn_signup)
    public void onSignUpButtonClick() {
        String username = etUsername.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        presenter.signUp(username, password, email);
    }

    @Override
    public void onSignUpSuccess() {
        navigateToMain();
    }

    private void navigateToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onSignUpFailed(String message) {
        Timber.e(message);
    }
}
