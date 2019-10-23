package com.eslamwaheed.togglandroid.ui.activity.main;

import androidx.fragment.app.Fragment;

import com.eslamwaheed.togglandroid.ui.base.BaseView;

public interface MainView extends BaseView {
    void changeNavigationFragment(int id);

    void replaceFragment(Fragment fragment);
}
