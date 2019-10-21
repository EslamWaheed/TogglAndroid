package com.eslamwaheed.togglandroid.ui.activity.login;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.eslamwaheed.togglandroid.R;
import com.eslamwaheed.togglandroid.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginView {
    private static final String TAG = "SplashActivity";

    @Inject
    LoginPresenter<LoginView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
    }

    @Override
    public void onFragmentAttached(String tag) {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
