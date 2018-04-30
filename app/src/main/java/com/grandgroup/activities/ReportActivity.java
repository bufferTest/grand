package com.grandgroup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.grandgroup.R;

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
                mContext.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;

        }
    }
}
