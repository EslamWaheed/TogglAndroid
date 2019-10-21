package com.eslamwaheed.togglandroid.data.prefs;


import android.content.Context;
import android.content.SharedPreferences;

import com.eslamwaheed.togglandroid.di.ApplicationContext;
import com.eslamwaheed.togglandroid.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PreferencesHelperIMP implements PreferencesHelper {
    private static final String UserName = "user_name";
    private static final String Email = "email";
    private static final String UserPassword = "user_password";
    private static final String Token = "token";

    private final SharedPreferences mPrefs;
    private final Context context;


    @Inject
    PreferencesHelperIMP(@ApplicationContext Context context,
                         @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
        this.context = context;
    }

    @Override
    public void setUserName(String userName) {
        mPrefs.edit().putString(UserName, userName).apply();
    }

    @Override
    public String getUserName() {
        return mPrefs.getString(UserName, null);
    }

    @Override
    public void setEmail(String email) {
        mPrefs.edit().putString(Email, email).apply();
    }

    @Override
    public String getEmail() {
        return mPrefs.getString(Email, null);
    }

    @Override
    public void setUserPassword(String userPassword) {
        mPrefs.edit().putString(UserPassword, userPassword).apply();
    }

    @Override
    public String getUserPassword() {
        return mPrefs.getString(UserPassword, null);
    }

    @Override
    public void setToken(String token) {
        mPrefs.edit().putString(Token, token).apply();
    }

    @Override
    public String getToken() {
        return mPrefs.getString(Token, null);
    }

}
