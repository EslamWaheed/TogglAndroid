package com.eslamwaheed.togglandroid.ui.activity.splash;

import com.eslamwaheed.togglandroid.data.DataManager;
import com.eslamwaheed.togglandroid.ui.base.BasePresenterIMP;
import com.eslamwaheed.togglandroid.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenterIMP<V extends SplashView> extends BasePresenterIMP<V> implements SplashPresenter<V> {
    @Inject
    public SplashPresenterIMP(DataManager mDataManager, CompositeDisposable mCompositeDisposable, SchedulerProvider mSchedulerProvider) {
        super(mDataManager, mCompositeDisposable, mSchedulerProvider);
    }
}
