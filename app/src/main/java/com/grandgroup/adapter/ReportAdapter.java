package com.grandgroup.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grandgroup.R;
import com.grandgroup.model.IncidentModel;
import com.grandgroup.model.RiskReportModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.CustomHolder> {

    private ArrayList<IncidentModel> incidentList;
    private ArrayList<RiskReportModel> riskList;
    private Context context;
    private int reportSelection;

    public ReportAdapter(Context context,int reportSelection, ArrayList<IncidentModel> incidentList) {
        this.incidentList = incidentList;
        this.context = context;
        this.reportSelection = reportSelection;
    }
    public ReportAdapter(Context context, ArrayList<RiskReportModel> riskList,int reportSelection) {
        this.riskList = riskList;
        this.context = context;
        this.reportSelection = reportSelection;
    }

    @NonNull
    @Override
    public ReportAdapter.CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item_layout, parent, false);
        return new ReportAdapter.CustomHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportAdapter.CustomHolder holder, int position) {
       // holder.tvText.setVisibility(View.VISIBLE);
        if(reportSelection == 0)
        holder.tvText.setText( "ID :"+incidentList.get(position).getOjectId());
        else if(reportSelection == 1)
            holder.tvText.setText( "ID :"+riskList.get(position).getObjectId());
    }

    @Override
    public int getItemCount() {
        int listSize =0;
         if(reportSelection == 0)
             listSize = incidentList.size();
         else if(reportSelection == 1)
             listSize = riskList.size();
        return listSize;
    }

    public class CustomHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_text)
        TextView tvText;
        @BindView(R.id.tv_time)
        TextView tvTime;

        public CustomHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
