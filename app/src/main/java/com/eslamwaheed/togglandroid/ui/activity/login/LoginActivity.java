package com.eslamwaheed.togglandroid.ui.activity.login;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.eslamwaheed.togglandroid.R;
import com.eslamwaheed.togglandroid.model.user.UserResponse;
import com.eslamwaheed.togglandroid.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginView {
    private static final String TAG = "LoginActivity";

    @Inject
    LoginPresenter<LoginView> mPresenter;

    @BindView(R.id.editText_activity_login_username)
    EditText editText_activity_login_username;
    @BindView(R.id.editText_activity_login_password)
    EditText editText_activity_login_password;
    @BindView(R.id.cardView_activity_login_login)
    CardView cardView_activity_login_login;

    String username;
    String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        cardView_activity_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] authkay;
                username = editText_activity_login_username.getText().toString();
                password = editText_activity_login_password.getText().toString();
                if (username.isEmpty()) {
                    editText_activity_login_username.setError(getResources().getString(R.string.username_required));
                }
                if (password.isEmpty()) {
                    editText_activity_login_password.setError(getResources().getString(R.string.password_required));
                }
                if (!username.isEmpty() && !password.isEmpty()) {
                    authkay = (username + ":" + password).getBytes();
                    mPresenter.login("Basic " + Base64.encodeToString(authkay, Base64.NO_WRAP));
                }
            }
        });
    }

    @Override
    public void onFragmentAttached(String tag) {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public void showLogin(UserResponse userResponse) {
        //todo save user date
        mPresenter.saveUser(username, password, userResponse.getData().getApi_token(), "1");
        //todo goto main activity

    }

    @Override
    public void showLoginError(String error) {
        //todo show error message
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
