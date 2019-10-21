package com.eslamwaheed.togglandroid.di.module;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.eslamwaheed.togglandroid.di.ActivityContext;
import com.eslamwaheed.togglandroid.ui.activity.login.LoginPresenter;
import com.eslamwaheed.togglandroid.ui.activity.login.LoginPresenterIMP;
import com.eslamwaheed.togglandroid.ui.activity.login.LoginView;
import com.eslamwaheed.togglandroid.ui.activity.splash.SplashPresenter;
import com.eslamwaheed.togglandroid.ui.activity.splash.SplashPresenterIMP;
import com.eslamwaheed.togglandroid.ui.activity.splash.SplashView;
import com.eslamwaheed.togglandroid.ui.base.BasePresenter;
import com.eslamwaheed.togglandroid.ui.base.BasePresenterIMP;
import com.eslamwaheed.togglandroid.ui.base.BaseView;
import com.eslamwaheed.togglandroid.utils.rx.AppSchedulerProvider;
import com.eslamwaheed.togglandroid.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule { // providing (Adapters, Presenters, LayoutManagers, Disposables)
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    BasePresenter<BaseView> provideBasePresenter(BasePresenterIMP<BaseView> presenter) {
        return presenter;
    }

    @Provides
    SplashPresenter<SplashView> provideSplashPresenter(SplashPresenterIMP<SplashView> presenterIMP) {
        return presenterIMP;
    }

    @Provides
    LoginPresenter<LoginView> providesLoginPresenter(LoginPresenterIMP<LoginView> presenterIMP) {
        return presenterIMP;
    }
}
