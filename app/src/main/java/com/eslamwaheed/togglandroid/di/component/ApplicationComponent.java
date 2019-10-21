package com.eslamwaheed.togglandroid.di.component;


import android.app.Application;
import android.content.Context;

import com.eslamwaheed.togglandroid.App;
import com.eslamwaheed.togglandroid.data.DataManager;
import com.eslamwaheed.togglandroid.data.prefs.PreferencesHelper;
import com.eslamwaheed.togglandroid.di.ApplicationContext;
import com.eslamwaheed.togglandroid.di.module.ApplicationModule;
import com.eslamwaheed.togglandroid.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    // inject into
    void inject(App app);

    // exposing these instances to dependent components
    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

    PreferencesHelper getPreferencesHelper();
}