package com.eslamwaheed.togglandroid.ui.activity.login;

import com.eslamwaheed.togglandroid.ui.base.BasePresenter;

public interface LoginPresenter<V extends LoginView> extends BasePresenter<V> {
    void login(String authkey);

    void saveUser(String username, String password, String token, String status);
}
