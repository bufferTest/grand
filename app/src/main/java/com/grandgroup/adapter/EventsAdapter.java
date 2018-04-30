package com.grandgroup.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grandgroup.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.CustomHolder> {

    private ArrayList<String> dayList;

    public EventsAdapter(ArrayList<String> daysList) {
        this.dayList = daysList;
    }

    @NonNull
    @Override
    public EventsAdapter.CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_item, parent, false);
        return new CustomHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.CustomHolder holder, int position) {
        holder.tvText.setText(dayList.get(position));
    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    public class CustomHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_text)
        TextView tvText;

        public CustomHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}