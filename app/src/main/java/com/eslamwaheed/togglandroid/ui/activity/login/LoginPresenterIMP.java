package com.eslamwaheed.togglandroid.ui.activity.login;

import com.eslamwaheed.togglandroid.data.DataManager;
import com.eslamwaheed.togglandroid.ui.base.BasePresenterIMP;
import com.eslamwaheed.togglandroid.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenterIMP<V extends LoginView> extends BasePresenterIMP<V> implements LoginPresenter<V> {
    @Inject
    public LoginPresenterIMP(DataManager mDataManager, CompositeDisposable mCompositeDisposable, SchedulerProvider mSchedulerProvider) {
        super(mDataManager, mCompositeDisposable, mSchedulerProvider);
    }
}
