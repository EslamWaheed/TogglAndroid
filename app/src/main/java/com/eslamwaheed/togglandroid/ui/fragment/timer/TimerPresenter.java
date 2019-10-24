package com.eslamwaheed.togglandroid.ui.fragment.timer;

import com.eslamwaheed.togglandroid.ui.base.BasePresenter;

public interface TimerPresenter<V extends TimerView> extends BasePresenter<V> {
    void getTimer(String authkey,
                  String start_date,
                  String end_date);
}
