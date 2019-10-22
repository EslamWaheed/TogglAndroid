package com.eslamwaheed.togglandroid.ui.base;

public interface BasePresenter<V extends BaseView> {

    void onAttach(V view);

    void onDetach();

    void handleApiError(Throwable error);

    void setUserName(String userName);

    String getUserName();

    void setUserPassword(String userPassword);

    String getUserPassword();

    void setToken(String token);

    String getToken();

    void setStatus(String status);

    String getStatus();
}
