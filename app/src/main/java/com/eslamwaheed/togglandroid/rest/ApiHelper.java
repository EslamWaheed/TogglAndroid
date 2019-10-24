package com.eslamwaheed.togglandroid.rest;

import com.eslamwaheed.togglandroid.model.timer.TimerResponse;
import com.eslamwaheed.togglandroid.model.user.UserResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiHelper {
    @GET("me")
    Single<UserResponse> getUser(@Header("Authorization") String authkey);

    @GET("time_entries")
    Single<List<TimerResponse>> getTimer(@Header("Authorization") String authkey,
                                         @Query("start_date") String start_date,
                                         @Query("end_date") String end_date);
}
