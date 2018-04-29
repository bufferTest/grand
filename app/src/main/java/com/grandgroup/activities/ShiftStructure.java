package com.grandgroup.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.grandgroup.R;
import com.grandgroup.utills.AppConstant;
import com.grandgroup.utills.AppPrefrence;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShiftStructure extends BaseActivity {
    private AppCompatActivity mContext;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift_structure);
        setInitialData();
    }

    private void setInitialData() {
        ButterKnife.bind(this);
        mContext = ShiftStructure.this;
        tvTitle.setText("Shift Structure");
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
