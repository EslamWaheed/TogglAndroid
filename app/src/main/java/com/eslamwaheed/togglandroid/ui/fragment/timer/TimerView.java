package com.eslamwaheed.togglandroid.ui.fragment.timer;

import com.eslamwaheed.togglandroid.model.timer.TimerResponse;
import com.eslamwaheed.togglandroid.ui.base.BaseView;

import java.util.List;

public interface TimerView extends BaseView {
    void showTimer(List<TimerResponse> timerResponses);

    void showTimerError(String error);
}
