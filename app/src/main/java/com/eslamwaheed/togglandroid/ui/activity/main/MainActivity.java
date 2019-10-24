package com.eslamwaheed.togglandroid.ui.activity.main;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.eslamwaheed.togglandroid.R;
import com.eslamwaheed.togglandroid.ui.base.BaseActivity;
import com.eslamwaheed.togglandroid.ui.fragment.timer.TimerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {
    private static final String TAG = "MainActivity";

    @Inject
    MainPresenter<MainView> mPresenter;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mPresenter.onNavigationClick(menuItem.getItemId());
                return true;
            }
        });
        pushFragment(new TimerFragment());
    }

    @Override
    public void changeNavigationFragment(int id) {
        switch (id) {
            case R.id.navigation_timer:
                Log.d(TAG, "navigation_home");
                replaceFragment(new TimerFragment());
                break;
        }
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onFragmentAttached(String tag) {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
