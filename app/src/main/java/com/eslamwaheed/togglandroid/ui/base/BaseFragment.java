package com.eslamwaheed.togglandroid.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.eslamwaheed.togglandroid.di.component.ActivityComponent;
import com.eslamwaheed.togglandroid.utils.CommonUtils;
import com.google.android.material.snackbar.Snackbar;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView {
    public static final String TAG = "BaseFragment";
    private BaseActivity mActivity;
    private Unbinder mUnBinder;
    private AlertDialog mProgressDialog;

    ProgressDialog mLoadingProgressDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached(TAG);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    public ActivityComponent getActivityComponent() {
        if (mActivity != null) {
            return mActivity.getActivityComponent();
        }
        return null;
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }


    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void pushFragment(Fragment fragment) {

    }

    @Override
    public void showFullLoading() {
        hideFullLoading();
//        mProgressDialog = CommonUtils.showFullLoadingDialog(this.getContext());
    }

    @Override
    public void hideFullLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void showToastMessage(String message) {
        if (mActivity != null) {
            mActivity.showToastMessage(message);
        }
    }

    @Override
    public void showToastMessage(int resId) {
        if (mActivity != null) {
            mActivity.showToastMessage(resId);
        }
    }

    @Override
    public void showSnackMessage(String message) {
        Snackbar snackbar = Snackbar.make(getBaseActivity().findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
//        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(ContextCompat.getColor(getBaseActivity(), R.color.colorPrimary));
        snackbar.show();
    }

    @Override
    public void showSnackMessage(int resId) {
        Snackbar snackbar = Snackbar.make(getBaseActivity().findViewById(android.R.id.content),
                resId, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
//        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(ContextCompat.getColor(getBaseActivity(), R.color.colorPrimary));
        snackbar.show();
    }

    @Override
    public void showLoadingProgressDialog(String message) {
        hideLoadingProgressDialog();
        mLoadingProgressDialog = CommonUtils.showLoadingProgressDialog(this.getContext(), message);
    }

    @Override
    public void hideLoadingProgressDialog() {
        if (mLoadingProgressDialog != null) {
            mLoadingProgressDialog.dismiss();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (mActivity != null) {
            return mActivity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    public interface Callback {

        void onFragmentAttached(String tag);

        void pushFragment(Fragment fragment);

        void onFragmentDetached(String tag);
    }

}
