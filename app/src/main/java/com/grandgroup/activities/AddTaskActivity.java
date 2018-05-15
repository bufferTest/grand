package com.grandgroup.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.grandgroup.R;
import com.grandgroup.views.CustomDateDialog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTaskActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_event_date)
    TextView tvEventDate;
    private AppCompatActivity mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setInitialData();
    }

    private void setInitialData() {
        mContext = AddTaskActivity.this;
        ButterKnife.bind(mContext);
        tvTitle.setText("Add Task");
    }

    @OnClick({R.id.btn_back, R.id.tv_event_date})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                mContext.overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
                break;
            case R.id.tv_event_date:
                CustomDateDialog.getInstance().DatePicker(mContext, new CustomDateDialog.DateDialogListener() {
                    @Override
                    public void onOkayClick(int date, int month, int year) {
                        String dayOfMonth = "", monthOfYear = "", selectedDate, formattedDate = "";

                        monthOfYear = (month < 10) ? "0"+ month+1 : ""+month+1;
                        dayOfMonth = (date < 10) ? "0"+ date : ""+date;
                        selectedDate = monthOfYear +" "+ dayOfMonth+", "+ year;
                        Log.e("day", selectedDate);
                        DateFormat originalFormat = new SimpleDateFormat("MM dd, yyyy", Locale.ENGLISH);
                        DateFormat targetFormat = new SimpleDateFormat("MMMM dd, yyyy");
                        try {
                            Date date1 = originalFormat.parse(selectedDate);
                             formattedDate = targetFormat.format(date1);
                            Log.e("day1", formattedDate);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        tvEventDate.setText(formattedDate);
                    }
                });
        }
    }
}
