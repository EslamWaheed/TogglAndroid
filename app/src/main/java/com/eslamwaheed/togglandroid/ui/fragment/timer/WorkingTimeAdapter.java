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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkingTimeAdapter extends RecyclerView.Adapter<WorkingTimeAdapter.ViewHolder> {
    private static final String TAG = "WorkingTimeAdapter";

    TimerPresenter<TimerView> timerPresenter;
    Context context;
    List<TimerResponse> dataList;

    public WorkingTimeAdapter(TimerPresenter<TimerView> timerPresenter, Context context) {
        this.timerPresenter = timerPresenter;
        this.context = context;
        dataList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.working_timer_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TimerResponse timerResponse = dataList.get(i);
        viewHolder.textView_working_timer_items_title.setText(timerResponse.getDescription());
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
        @BindView(R.id.textView_working_timer_items_title)
        TextView textView_working_timer_items_title;

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
