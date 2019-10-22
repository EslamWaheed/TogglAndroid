package com.eslamwaheed.togglandroid.ui.activity.main;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.eslamwaheed.togglandroid.R;
import com.eslamwaheed.togglandroid.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {
    private static final String TAG = "MainActivity";

    @Inject
    MainPresenter<MainView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
