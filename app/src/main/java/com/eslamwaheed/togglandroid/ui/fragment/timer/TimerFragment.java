package com.eslamwaheed.togglandroid.ui.fragment.timer;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eslamwaheed.togglandroid.R;
import com.eslamwaheed.togglandroid.di.component.ActivityComponent;
import com.eslamwaheed.togglandroid.model.timer.TimerResponse;
import com.eslamwaheed.togglandroid.ui.base.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimerFragment extends BaseFragment implements TimerView {
    private final static String TAG = "TimerFragment";

    @Inject
    TimerPresenter<TimerView> mPresenter;
    View view;

    @BindView(R.id.recyclerView_fragment_timer)
    RecyclerView recyclerView_fragment_timer;

    @BindView(R.id.recyclerView_fragment_timer_days)
    RecyclerView recyclerView_fragment_timer_days;

    WorkingTimeAdapter workingTimeAdapter;
    WorkingTimeDaysAdapter workingTimeDaysAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_timer, container, false);
            initInjections(view);
            initViews(view);
        } else {
            initInjections(view);
        }
        return view;
    }

    private void initViews(final View view) {
        byte[] authkay;
        String username = mPresenter.getUserName();
        String password = mPresenter.getUserPassword();
        recyclerView_fragment_timer.setLayoutManager(new LinearLayoutManager(getContext()));
        workingTimeAdapter = new WorkingTimeAdapter(mPresenter, getContext());
        recyclerView_fragment_timer.setAdapter(workingTimeAdapter);
        authkay = (username + ":" + password).getBytes();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00");
        Calendar calendar = Calendar.getInstance();
        Date startDate = calendar.getTime();
        calendar.add(Calendar.MONTH, -1);
        Date endDate = calendar.getTime();
        String start = df.format(startDate);
        String end = df.format(endDate);
        mPresenter.getTimer("Basic " + Base64.encodeToString(authkay, Base64.NO_WRAP), end + 'Z', start + 'Z');
        //working time days
        recyclerView_fragment_timer_days.setLayoutManager(new LinearLayoutManager(getContext()));
        workingTimeDaysAdapter = new WorkingTimeDaysAdapter(mPresenter, getContext());
        recyclerView_fragment_timer_days.setAdapter(workingTimeDaysAdapter);
    }

    private void initInjections(View view) {
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
    }

    @Override
    public void showTimer(List<TimerResponse> timerResponses) {
        workingTimeAdapter.refreshList(timerResponses);
        Map<String, List<TimerResponse>> timerPerDate = timerResponses.stream()
                .collect(Collectors.groupingBy(TimerResponse::getStartFormated));
        Log.i("Timer Map", timerPerDate.toString());
        workingTimeDaysAdapter.refreshList(timerPerDate);
    }

    @Override
    public void showTimerError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
