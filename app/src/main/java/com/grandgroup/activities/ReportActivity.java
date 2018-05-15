package com.grandgroup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.grandgroup.R;
import com.grandgroup.adapter.ReportAdapter;
import com.grandgroup.model.IncidentModel;
import com.grandgroup.model.RiskReportModel;
import com.grandgroup.utills.CallProgressWheel;
import com.grandgroup.utills.GrandGroupHelper;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReportActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    private AppCompatActivity mContext;
    // Spinner Drop down elements
    List categories = new ArrayList();
    ArrayList incidentReportList ;
    ArrayList riskReportList;
    String selectedCat = "Incedent Report";

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.btn_add)
    Button btnAdd;

    @BindView(R.id.spinner_report)
    Spinner spinnerReport;

    @BindView(R.id.rv_reports)
    RecyclerView rvReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        setInitialData();
    }

    private void setInitialData() {
        ButterKnife.bind(this);
        mContext = ReportActivity.this;
        tvTitle.setText("Report");
        btnAdd.setVisibility(View.VISIBLE);
        spinnerReport.setOnItemSelectedListener(this);

        categories.add("Incedent Report");
        categories.add("Risk Report");

        // Creating adapter for spinner
        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinnerReport.setAdapter(dataAdapter);
        if (selectedCat.equalsIgnoreCase("Incedent Report")) {
           getReports("IncidentReport");
        } else if (selectedCat.equalsIgnoreCase("Risk Report")) {
            getReports("RiskReport");
        }
    }

    @OnClick({R.id.btn_back,R.id.btn_add})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                mContext.overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
                break;

            case R.id.btn_add:
                if (selectedCat.equalsIgnoreCase("Incedent Report")) {
                    Intent intent = new Intent(mContext, IncidentReportsActivity.class);
                    startActivity(intent);
                    mContext.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                } else if (selectedCat.equalsIgnoreCase("Risk Report")) {
                    Intent intent = new Intent(mContext, RiskReportActivity.class);
                    startActivity(intent);
                    mContext.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                }
                break;
        }
    }

    private void getReports(String reportType) {
        if (GrandGroupHelper.grandGroupHelper(mContext).CheckIsConnectedToInternet()) {
            CallProgressWheel.showLoadingDialog(mContext);
            ParseQuery parseQuery = new ParseQuery(reportType);
            parseQuery.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> reports, ParseException e) {
                    if (e == null) {
                        riskReportList = new ArrayList();
                        incidentReportList = new ArrayList();
                        CallProgressWheel.dismissLoadingDialog();
                        if (reports.size() > 0) {
                            if (selectedCat.equalsIgnoreCase("Incedent Report")) {
                                for (int i = 0; i < reports.size(); i++) {
                                    IncidentModel incidentModel = new IncidentModel();
                                    incidentModel.setOjectId(reports.get(i).getObjectId());
                                    incidentReportList.add(incidentModel);
                                }
                                setAdapter(0, reports);
                            }

                        else if (selectedCat.equalsIgnoreCase("Risk Report")) {
                            for (int i = 0; i < reports.size(); i++) {
                                RiskReportModel riskReportModel = new RiskReportModel();
                                riskReportModel.setObjectId(reports.get(i).getObjectId());
                                riskReportList.add(riskReportModel);
                            }
                            setAdapter(1, reports);
                        }
                    } else {
                            CallProgressWheel.dismissLoadingDialog();
                        }
                    }
                }

            });
        } else {
            CallProgressWheel.dismissLoadingDialog();
        }
    }

    private void setAdapter(int userSelection, final List<ParseObject> reports) {
        try {
            if(userSelection ==0) {
                if (incidentReportList.size() > 0) {
                    LinearLayoutManager llm = new LinearLayoutManager(this);
                    llm.setOrientation(LinearLayoutManager.VERTICAL);
                    rvReports.setLayoutManager(llm);
                    ReportAdapter adapter = new ReportAdapter(mContext, userSelection,incidentReportList,  new ReportAdapter.ItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            ParseObject riskReportObject =  reports.get(position);
                            Intent intent = new Intent(mContext, RiskReportActivity.class);
                            intent.putExtra("incidentReportObject", riskReportObject);
                            startActivity(intent);
                            Toast.makeText(mContext,"Nikhil Clicked", Toast.LENGTH_LONG).show();
                        }
                    });
                    rvReports.setHasFixedSize(true);
                    rvReports.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    rvReports.setVisibility(View.VISIBLE);
                    rvReports.setVisibility(View.GONE);
                }
            }
            else if(userSelection ==1){
                LinearLayoutManager llm = new LinearLayoutManager(this);
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                rvReports.setLayoutManager(llm);
                ReportAdapter adapter = new ReportAdapter(mContext, riskReportList,userSelection,  new ReportAdapter.ItemClickListener() {
                    @Override
                    public void onClick(int position) {
                        ParseObject riskReportObject =  reports.get(position);
                        Intent intent = new Intent(mContext, RiskReportActivity.class);
                        intent.putExtra("riskReportObject", riskReportObject);
                        startActivity(intent);
                        Toast.makeText(mContext,"Nikhil Clicked", Toast.LENGTH_LONG).show();
                    }
                });

                rvReports.setHasFixedSize(true);
                rvReports.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            } else {
                rvReports.setVisibility(View.VISIBLE);
                rvReports.setVisibility(View.GONE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCat = parent.getItemAtPosition(position).toString();
        if (selectedCat.equalsIgnoreCase("Incedent Report")) {
            getReports("IncidentReport");
        } else if (selectedCat.equalsIgnoreCase("Risk Report")) {
            getReports("RiskReport");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
