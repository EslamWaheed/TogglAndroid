package com.eslamwaheed.togglandroid.ui.base;


import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.eslamwaheed.togglandroid.App;
import com.eslamwaheed.togglandroid.R;
import com.eslamwaheed.togglandroid.di.component.ActivityComponent;
import com.eslamwaheed.togglandroid.di.component.DaggerActivityComponent;
import com.eslamwaheed.togglandroid.di.module.ActivityModule;
import com.eslamwaheed.togglandroid.utils.LocaleManager;

import javax.inject.Inject;

import butterknife.Unbinder;

import static android.content.pm.PackageManager.GET_META_DATA;

public abstract class BaseActivity extends AppCompatActivity implements BaseView, BaseFragment.Callback {
    private static final String TAG = "BaseActivity";

    private ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;
    private AlertDialog mProgressDialog;

    @Inject
    BasePresenter<BaseView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((App) getApplication()).getComponent()) // for exposing needed instances from parent component
                .build();
        mActivityComponent.inject(this);
        resetTitles();
    }

    private void setAppLocale(String appLanguage) {
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }


    public void hideKeyboard() {
    }


    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void pushFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void showFullLoading() {
//        mProgressDialog = CommonUtils.showFullLoadingDialog(this);
    }

    @Override
    public void hideFullLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showToastMessage(String message) {

    }

    @Override
    public void showToastMessage(@StringRes int resId) {
    }

    @Override
    public void showSnackMessage(String message) {
    }

    @Override
    public void showSnackMessage(int message) {

    }

    @Override
    public void showLoadingProgressDialog(String message) {

    }

    @Override
    public void hideLoadingProgressDialog() {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    public interface Callback {

        void onFragmentAttached(String tag);

        void pushFragment(Fragment fragment);

        void onFragmentDetached(String tag);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    protected void resetTitles() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), GET_META_DATA);
            if (info.labelRes != 0) {
                setTitle(info.labelRes);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
