package org.codenergic.theskeleton.login;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.helper.AlertHelper;
import org.codenergic.theskeleton.main.MainActivity;
import org.codenergic.theskeleton.register.RegisterActivity;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

/**
 * Created by putrice on 9/22/17.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.input_email)
    EditText etEmail;

    @BindView(R.id.input_password)
    EditText etPassword;

    @Inject
    LoginPresenter presenter;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public BasePresenter attachPresenter() {
        return presenter;
    }

    @OnClick(R.id.btn_login)
    public void onButtonSubmitClick() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        presenter.login(email, password);
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
        navigateToMain();
    }

    private void navigateToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onLoginFailed(String errorMessage) {
        AlertHelper.showWarningAlert(this, errorMessage);
    }
}
