package com.eslamwaheed.togglandroid.ui.base;

import com.eslamwaheed.togglandroid.data.DataManager;
import com.eslamwaheed.togglandroid.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenterIMP<V extends BaseView> implements BasePresenter<V> {
    private static final String TAG = "BasePresenterIMP";

    private final DataManager mDataManager;
    private final CompositeDisposable mCompositeDisposable;
    private final SchedulerProvider mSchedulerProvider;

    private V mMvpView;

    @Inject
    public BasePresenterIMP(DataManager mDataManager, CompositeDisposable mCompositeDisposable, SchedulerProvider mSchedulerProvider) {
        this.mDataManager = mDataManager;
        this.mCompositeDisposable = mCompositeDisposable;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    @Override
    public void handleApiError(Throwable error) {
        // write the logic to  inform error to the user
        getBaseView().showToastMessage(error.getMessage());
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getBaseView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void setUserName(String userName) {
        mDataManager.setUserName(userName);
    }

    @Override
    public String getUserName() {
        return mDataManager.getUserName();
    }

    @Override
    public void setUserPassword(String userPassword) {
        mDataManager.setUserPassword(userPassword);
    }

    @Override
    public String getUserPassword() {
        return mDataManager.getUserPassword();
    }

    @Override
    public void setToken(String token) {
        mDataManager.setToken(token);
    }

    @Override
    public String getToken() {
        return mDataManager.getToken();
    }

    @Override
    public void setStatus(String status) {
        mDataManager.setStatus(status);
    }

    @Override
    public String getStatus() {
        return mDataManager.getStatus();
    }
}
