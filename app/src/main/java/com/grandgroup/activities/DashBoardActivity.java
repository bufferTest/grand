package com.grandgroup.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.grandgroup.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashBoardActivity extends AppCompatActivity {
    private AppCompatActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dash_board);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ButterKnife.bind(this);
        mContext = DashBoardActivity.this;

    }

    @OnClick({R.id.iv_notifications, R.id.iv_settings, R.id.iv_task_manager, R.id.iv_attendance, R.id.iv_shift_structure, R.id.iv_report, R.id.iv_my_profile, R.id.iv_logout})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_notifications:
               goToActivity(NotificationsActivity.class);
                break;

            case R.id.iv_settings:
                Toast.makeText(mContext, "Under Development", Toast.LENGTH_LONG).show();
                break;

            case R.id.iv_task_manager:
                goToActivity(TaskManagerActivity.class);
                break;

            case R.id.iv_attendance:
                goToActivity(AttendanceActivity.class);
                break;

            case R.id.iv_shift_structure:
                goToActivity(ShiftStructure.class);
                break;

            case R.id.iv_report:
                goToActivity(ReportActivity.class);
                break;

            case R.id.iv_my_profile:
                goToActivity(UserProfileActivity.class);
                break;

            case R.id.iv_logout:
                Toast.makeText(mContext, "Under Development", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void goToActivity(Class<?> classname) {
        startActivity(new Intent(mContext, classname));
        mContext.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}

