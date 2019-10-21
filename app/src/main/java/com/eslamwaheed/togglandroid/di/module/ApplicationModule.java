package com.eslamwaheed.togglandroid.di.module;


import android.app.Application;
import android.content.Context;

import com.eslamwaheed.togglandroid.R;
import com.eslamwaheed.togglandroid.data.DataManager;
import com.eslamwaheed.togglandroid.data.DataManagerIMP;
import com.eslamwaheed.togglandroid.data.prefs.PreferencesHelper;
import com.eslamwaheed.togglandroid.data.prefs.PreferencesHelperIMP;
import com.eslamwaheed.togglandroid.di.ApplicationContext;
import com.eslamwaheed.togglandroid.di.PreferenceInfo;
import com.eslamwaheed.togglandroid.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerIMP dataManagerIMP) {
        return dataManagerIMP;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName(@ApplicationContext Context context) {
        return context.getString(R.string.app_name) + AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesHelperIMP preferencesHelperIMP) {
        return preferencesHelperIMP;
    }
}