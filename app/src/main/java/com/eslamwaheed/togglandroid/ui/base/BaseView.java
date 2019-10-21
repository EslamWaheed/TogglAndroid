package com.eslamwaheed.togglandroid.ui.base;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

public interface BaseView {

    void pushFragment(Fragment fragment);

    void showFullLoading();

    void hideFullLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showToastMessage(String message);

    void showToastMessage(@StringRes int resId);

    void showSnackMessage(String message);

    void showSnackMessage(@StringRes int resId);

    void showLoadingProgressDialog(String message);

    void hideLoadingProgressDialog();

    boolean isNetworkConnected();

    void hideKeyboard();

}
