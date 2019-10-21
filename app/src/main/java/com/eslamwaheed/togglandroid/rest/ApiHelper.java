package com.eslamwaheed.togglandroid.rest;

import com.eslamwaheed.togglandroid.model.user.UserResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiHelper {

//    @FormUrlEncoded
//    @POST("login")
//    Single<LoginResponse> login(@FieldMap Map<String, String> params);

    @GET("me")
    Single<UserResponse> getUser(@Header("Authorization") String authkey);
}
