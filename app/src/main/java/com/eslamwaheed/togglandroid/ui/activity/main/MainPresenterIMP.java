package com.eslamwaheed.togglandroid.ui.activity.main;

import com.eslamwaheed.togglandroid.data.DataManager;
import com.eslamwaheed.togglandroid.ui.base.BasePresenterIMP;
import com.eslamwaheed.togglandroid.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenterIMP<V extends MainView> extends BasePresenterIMP<V> implements MainPresenter<V> {
    @Inject
    public MainPresenterIMP(DataManager mDataManager, CompositeDisposable mCompositeDisposable, SchedulerProvider mSchedulerProvider) {
        super(mDataManager, mCompositeDisposable, mSchedulerProvider);
    }
}
