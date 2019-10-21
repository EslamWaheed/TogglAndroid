package com.eslamwaheed.togglandroid.data;


import com.eslamwaheed.togglandroid.model.user.UserResponse;

import io.reactivex.Single;

public interface DataManager {

    void setUserName(String userName);

    String getUserName();

    void setUserPassword(String userPassword);

    String getUserPassword();

    void setToken(String token);

    String getToken();

    Single<UserResponse> getUser(String authkey);

}

