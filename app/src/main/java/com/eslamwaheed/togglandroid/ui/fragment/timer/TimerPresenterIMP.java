package com.eslamwaheed.togglandroid.ui.fragment.timer;

import android.util.Log;

import com.eslamwaheed.togglandroid.data.DataManager;
import com.eslamwaheed.togglandroid.model.timer.TimerResponse;
import com.eslamwaheed.togglandroid.model.user.UserResponse;
import com.eslamwaheed.togglandroid.ui.base.BasePresenterIMP;
import com.eslamwaheed.togglandroid.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class TimerPresenterIMP<V extends TimerView> extends BasePresenterIMP<V> implements TimerPresenter<V> {
    private static final String TAG = "TimerPresenterIMP";

    @Inject
    public TimerPresenterIMP(DataManager mDataManager, CompositeDisposable mCompositeDisposable, SchedulerProvider mSchedulerProvider) {
        super(mDataManager, mCompositeDisposable, mSchedulerProvider);
    }

    @Override
    public void getTimer(String authkey, String start_date, String end_date) {
        getCompositeDisposable().add(getDataManager().getTimer(authkey, start_date, end_date)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<TimerResponse>>() {
                               @Override
                               public void accept(List<TimerResponse> timerResponses) {
                                   getBaseView().showTimer(timerResponses);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) {
                                   getBaseView().showTimerError("username or password is incorrect");
                                   Log.d(TAG, "accept: throwable error is: " + throwable.getLocalizedMessage());
                               }
                           }
                )
        );
    }
}
