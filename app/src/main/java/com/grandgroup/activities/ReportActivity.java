package com.grandgroup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.grandgroup.R;
import com.grandgroup.model.NotificationsModel;
import com.grandgroup.utills.CallProgressWheel;
import com.grandgroup.utills.GrandGroupHelper;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReportActivity extends BaseActivity {
    private AppCompatActivity mContext;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.btn_add)
    Button btnAdd;
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
    }

    @OnClick({R.id.btn_back})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                mContext.overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);

            case R.id.btn_add:
                Intent intent = new Intent(mContext, AddTaskActivity.class);
                startActivity(intent);
                mContext.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);break;
        }
    }

    private void getReports(String reportType){
        if (GrandGroupHelper.grandGroupHelper(mContext).CheckIsConnectedToInternet()) {
            CallProgressWheel.showLoadingDialog(mContext);

            ParseQuery<ParseObject> query = ParseQuery.getQuery(reportType);
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> reports, ParseException e) {
                    if (e == null) {
                        CallProgressWheel.dismissLoadingDialog();
                        if (reports.size() > 0) {
                            for (int i = 0; i < reports.size(); i++) {
//                                NotificationsModel notificationsModel = new NotificationsModel();
//                                notificationsModel.setTime(notifications.get(i).getString(getString(R.string.time)));
//                                notificationsModel.setMessage(notifications.get(i).getString(getString(R.string.message)));
//                                notificationsList.add(notificationsModel);
                            }
                        }
                     //   setAdapter();
                    } else {
                        CallProgressWheel.dismissLoadingDialog();

                    }
                }

            });
        } else {
            CallProgressWheel.dismissLoadingDialog();
        }
    }
}
