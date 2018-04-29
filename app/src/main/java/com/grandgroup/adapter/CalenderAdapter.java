package com.grandgroup.adapter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.grandgroup.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wegile on 25/7/17.
 */

public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.CustomHolder> {
    private AppCompatActivity mContext;
    private List<String> arrayList;
    private onDayClick ondayclick;
    private Calendar currentcalendar;
    private Calendar calendar;


    public CalenderAdapter(AppCompatActivity mContext, List<String> arrayList, Calendar calendar, onDayClick ondayclick) {
        this.mContext = mContext;
        this.arrayList = arrayList;
        this.calendar = calendar;
        this.ondayclick = ondayclick;
        currentcalendar = Calendar.getInstance();
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calender_model_layout, parent, false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        holder.material_calendar_day.setText(arrayList.get(position));
        if (arrayList.get(position) != null) {
            holder.saved_event_imageView.setVisibility(View.VISIBLE);
           /* if (arrayList.get(position).equals(day))
                holder.saved_event_imageView.setVisibility(View.GONE);*/
            if (currentcalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR))
                if (currentcalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))
                    if (arrayList.get(position).equalsIgnoreCase(String.valueOf(currentcalendar.get(Calendar.DAY_OF_MONTH))))
                        holder.material_calendar_day.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public interface onDayClick {
        void onDayClick(String position);
    }

    class CustomHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.material_calendar_day)
        TextView material_calendar_day;
        @BindView(R.id.saved_event_imageView)
        ImageView saved_event_imageView;
        @BindView(R.id.lay_day)
        RelativeLayout lay_day;


        CustomHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.lay_day)
        public void onDayClick() {
            if (arrayList.get(getLayoutPosition()) != null)
                ondayclick.onDayClick(arrayList.get(getLayoutPosition()));
        }
    }
}
