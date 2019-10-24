package com.eslamwaheed.togglandroid.ui.fragment.timer;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eslamwaheed.togglandroid.R;
import com.eslamwaheed.togglandroid.model.timer.TimerResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkingTimeDaysSubAdapter extends RecyclerView.Adapter<WorkingTimeDaysSubAdapter.ViewHolder> {
    private static final String TAG = "WorkingTimeDaysSubAdapter";

    TimerPresenter<TimerView> timerPresenter;
    Context context;
    List<TimerResponse> dataList;

    public WorkingTimeDaysSubAdapter(TimerPresenter<TimerView> timerPresenter, Context context) {
        this.timerPresenter = timerPresenter;
        this.context = context;
        dataList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_working_timer_days_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TimerResponse timerResponse = dataList.get(i);
        viewHolder.textView_sub_working_timer_days_items_title.setText(timerResponse.getDescription());
        viewHolder.textView_sub_working_timer_days_items_time.setText(DateUtils.formatElapsedTime(timerResponse.getDuration()));
    }

    @Override
    public int getItemCount() {
        if (dataList != null) {
            return dataList.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        @BindView(R.id.textView_sub_working_timer_days_items_title)
        TextView textView_sub_working_timer_days_items_title;
        @BindView(R.id.textView_sub_working_timer_days_items_time)
        TextView textView_sub_working_timer_days_items_time;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }
    }

    void refreshList(List<TimerResponse> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    void clearList() {
        this.dataList.clear();
        notifyDataSetChanged();
    }
}
