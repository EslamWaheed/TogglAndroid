package com.eslamwaheed.togglandroid.data.prefs;


public interface PreferencesHelper {
    void setUserName(String userName);

    String getUserName();

    void setEmail(String email);

    String getEmail();

    void setUserPassword(String userPassword);

    String getUserPassword();

    void setToken(String token);

    String getToken();

    void setStatus(String status);

    String getStatus();
}
