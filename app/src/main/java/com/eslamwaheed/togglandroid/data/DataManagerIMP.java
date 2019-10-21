package com.eslamwaheed.togglandroid.data;

import android.content.Context;

import com.eslamwaheed.togglandroid.data.prefs.PreferencesHelper;
import com.eslamwaheed.togglandroid.di.ApplicationContext;
import com.eslamwaheed.togglandroid.model.user.UserResponse;
import com.eslamwaheed.togglandroid.rest.ApiHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class DataManagerIMP implements DataManager {
    private static final String TAG = "DataManagerIMP";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private ApiHelper apiHelper;

    @Inject
    DataManagerIMP(@ApplicationContext Context context, PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        this.mContext = context;
        this.mPreferencesHelper = preferencesHelper;
        this.apiHelper = apiHelper;
    }


    @Override
    public void setUserName(String userName) {
        mPreferencesHelper.setUserName(userName);
    }

    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }

    @Override
    public void setUserPassword(String userPassword) {
        mPreferencesHelper.setUserPassword(userPassword);
    }

    @Override
    public String getUserPassword() {
        return mPreferencesHelper.getUserPassword();
    }

    @Override
    public void setToken(String token) {
        mPreferencesHelper.setToken(token);
    }

    @Override
    public String getToken() {
        return mPreferencesHelper.getToken();
    }

    @Override
    public Single<UserResponse> getUser(String authkey) {
        return apiHelper.getUser(authkey);
    }

}