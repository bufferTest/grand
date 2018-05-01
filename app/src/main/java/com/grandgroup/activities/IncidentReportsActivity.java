package com.grandgroup.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.grandgroup.R;
import com.grandgroup.views.CustomDateDialog;
import com.grandgroup.views.CustomTimeDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IncidentReportsActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    private AppCompatActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_reports);
        setInitialData();
    }

    private void setInitialData() {
        mContext = IncidentReportsActivity.this;
        ButterKnife.bind(mContext);
        tvTitle.setText("Incident Reports");
    }

    @OnClick({R.id.btn_back,R.id.tv_occurence_value,R.id.tv_ceased_time_value,R.id.tv_report_time_value})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                mContext.overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
                break;
            case R.id.tv_occurence_value:
                CustomDateDialog.getInstance().DatePicker(mContext, new CustomDateDialog.DateDialogListener() {
                    @Override
                    public void onOkayClick(int date, int month, int year) {
                        CustomTimeDialog.getInstance().timePicker(mContext, new CustomTimeDialog.TimeDialogListener() {
                            @Override
                            public void onOkayClick(String twentyFourTime, String TwelveHourTime) {

                            }
                        });
                    }
                });
            case R.id.tv_ceased_time_value:
                CustomDateDialog.getInstance().DatePicker(mContext, new CustomDateDialog.DateDialogListener() {
                    @Override
                    public void onOkayClick(int date, int month, int year) {
                        CustomTimeDialog.getInstance().timePicker(mContext, new CustomTimeDialog.TimeDialogListener() {
                            @Override
                            public void onOkayClick(String twentyFourTime, String TwelveHourTime) {

                            }
                        });
                    }
                });
            case R.id.tv_report_time_value:
                CustomDateDialog.getInstance().DatePicker(mContext, new CustomDateDialog.DateDialogListener() {
                    @Override
                    public void onOkayClick(int date, int month, int year) {
                        CustomTimeDialog.getInstance().timePicker(mContext, new CustomTimeDialog.TimeDialogListener() {
                            @Override
                            public void onOkayClick(String twentyFourTime, String TwelveHourTime) {

                            }
                        });
                    }
                });
        }
    }
}
