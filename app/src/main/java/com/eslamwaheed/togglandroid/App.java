package com.eslamwaheed.togglandroid;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.eslamwaheed.togglandroid.data.DataManager;
import com.eslamwaheed.togglandroid.di.component.ApplicationComponent;
import com.eslamwaheed.togglandroid.di.component.DaggerApplicationComponent;
import com.eslamwaheed.togglandroid.di.module.ApplicationModule;
import com.eslamwaheed.togglandroid.di.module.NetworkModule;
import com.eslamwaheed.togglandroid.utils.AppConstants;
import com.eslamwaheed.togglandroid.utils.LocaleManager;

import javax.inject.Inject;

public class App extends Application {
    private static final String TAG = "App";

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(AppConstants.API_BASE_URL))
                .build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
    }
}
