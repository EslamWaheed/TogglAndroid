package com.eslamwaheed.togglandroid.ui.activity.login;

import android.util.Log;

import com.eslamwaheed.togglandroid.data.DataManager;
import com.eslamwaheed.togglandroid.model.user.UserResponse;
import com.eslamwaheed.togglandroid.ui.base.BasePresenterIMP;
import com.eslamwaheed.togglandroid.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class LoginPresenterIMP<V extends LoginView> extends BasePresenterIMP<V> implements LoginPresenter<V> {
    private static final String TAG = "LoginPresenterIMP";

    @Inject
    public LoginPresenterIMP(DataManager mDataManager, CompositeDisposable mCompositeDisposable, SchedulerProvider mSchedulerProvider) {
        super(mDataManager, mCompositeDisposable, mSchedulerProvider);
    }

    @Override
    public void login(String authkey) {
        getCompositeDisposable().add(getDataManager().getUser(authkey)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<UserResponse>() {
                               @Override
                               public void accept(UserResponse userResponse) {
                                   getBaseView().showLogin(userResponse);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) {
                                   getBaseView().showLoginError("username or password is incorrect");
                                   Log.d(TAG, "accept: throwable error is: " + throwable.getLocalizedMessage());
                               }
                           }
                )
        );
    }

    @Override
    public void saveUser(String username, String password, String token, String status) {
        getDataManager().setUserName(username);
        getDataManager().setUserPassword(password);
        getDataManager().setToken(token);
        getDataManager().setStatus(status);

    }


}
