package com.eslamwaheed.togglandroid.data;


import com.eslamwaheed.togglandroid.model.timer.TimerResponse;
import com.eslamwaheed.togglandroid.model.user.UserResponse;

import java.util.List;

import io.reactivex.Single;

public interface DataManager {

    void setUserName(String userName);

    String getUserName();

    void setUserPassword(String userPassword);

    String getUserPassword();

    void setToken(String token);

    String getToken();

    void setStatus(String status);

    String getStatus();

    Single<UserResponse> getUser(String authkey);

    Single<List<TimerResponse>> getTimer(String authkey,
                                         String start_date,
                                         String end_date);
}

