package com.grandgroup.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.grandgroup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AttendanceActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private AppCompatActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        setInitialData();
    }

    private void setInitialData() {
        ButterKnife.bind(this);
        mContext = AttendanceActivity.this;
        tvTitle.setText("Attendance");
    }

    @OnClick({R.id.btn_back})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                mContext.overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
        }
    }
}
