package com.eslamwaheed.togglandroid.ui.fragment.timer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eslamwaheed.togglandroid.R;
import com.eslamwaheed.togglandroid.model.timer.TimerResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkingTimeDaysAdapter extends RecyclerView.Adapter<WorkingTimeDaysAdapter.ViewHolder> {
    private static final String TAG = "WorkingTimeDaysAdapter";

    TimerPresenter<TimerView> timerPresenter;
    Context context;
    Map<String, List<TimerResponse>> timerPerDate;
    List<String> stringKeys;

    public WorkingTimeDaysAdapter(TimerPresenter<TimerView> timerPresenter, Context context) {
        this.timerPresenter = timerPresenter;
        this.context = context;
        timerPerDate = new HashMap<>();
        stringKeys = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.working_timer_days_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String key = stringKeys.get(i);
        List<TimerResponse> timerResponses = timerPerDate.get(key);
        WorkingTimeDaysSubAdapter workingTimeDaysSubAdapter = new WorkingTimeDaysSubAdapter(timerPresenter, context);
        viewHolder.recyclerView_working_timer_days_items.setAdapter(workingTimeDaysSubAdapter);
        workingTimeDaysSubAdapter.refreshList(timerResponses);
        viewHolder.textView_working_timer_days_items_title.setText(key);
    }

    @Override
    public int getItemCount() {
        if (timerPerDate != null) {
            return timerPerDate.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        @BindView(R.id.textView_working_timer_days_items_title)
        TextView textView_working_timer_days_items_title;
        @BindView(R.id.textView_working_timer_days_items_time)
        TextView textView_working_timer_days_items_time;
        @BindView(R.id.recyclerView_working_timer_days_items)
        RecyclerView recyclerView_working_timer_days_items;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }

    }

    void refreshList(Map<String, List<TimerResponse>> timerPerDate) {
        this.timerPerDate.putAll(timerPerDate);
        for (Map.Entry<String, List<TimerResponse>> entry : timerPerDate.entrySet()) {
            stringKeys.add(entry.getKey());
        }
        notifyDataSetChanged();
    }

    void clearList() {
        this.timerPerDate.clear();
        notifyDataSetChanged();
    }
}