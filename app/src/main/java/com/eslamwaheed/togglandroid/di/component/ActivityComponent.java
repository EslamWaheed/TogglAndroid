package com.eslamwaheed.togglandroid.di.component;

import com.eslamwaheed.togglandroid.di.PerActivity;
import com.eslamwaheed.togglandroid.di.module.ActivityModule;
import com.eslamwaheed.togglandroid.ui.activity.login.LoginActivity;
import com.eslamwaheed.togglandroid.ui.activity.splash.SplashActivity;
import com.eslamwaheed.togglandroid.ui.base.BaseActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    // inject into  (Activities, fragments & dialogs)
    void inject(BaseActivity baseActivity);

    void inject(LoginActivity loginActivity);

    void inject(SplashActivity splashActivity);

}
