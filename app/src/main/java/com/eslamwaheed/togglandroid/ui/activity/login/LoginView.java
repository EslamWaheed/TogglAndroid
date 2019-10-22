package com.eslamwaheed.togglandroid.ui.activity.login;

import com.eslamwaheed.togglandroid.model.user.UserResponse;
import com.eslamwaheed.togglandroid.ui.base.BaseView;

public interface LoginView extends BaseView {
    void showLogin(UserResponse userResponse);

    void showLoginError(String error);
}
