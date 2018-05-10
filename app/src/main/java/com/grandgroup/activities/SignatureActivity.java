package com.grandgroup.activities;

import android.app.Activity;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.grandgroup.R;
import com.parse.ParseFile;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignatureActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.signaturePad)
    GestureOverlayView signature_pad;
    private AppCompatActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        setInitialData();
    }

    private void setInitialData() {
        mContext = SignatureActivity.this;
        ButterKnife.bind(mContext);
        tvTitle.setText("Signature");
    }

    @OnClick({R.id.btn_done})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_done:
                Bitmap signBitmap;
                signature_pad.setDrawingCacheEnabled(true);
                if (signature_pad.getVisibility() == View.VISIBLE)
                    if (signature_pad.getGesture() != null) {
                        signBitmap = Bitmap.createBitmap(signature_pad.getDrawingCache());
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        signBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                        byte[] image = out.toByteArray();
                        ParseFile file = new ParseFile("file.png", image);
//                        Uri signature = CommonUtils.getInstance().getImageUri(mContext,signBitmap);

                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("signBitmap",signBitmap);
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();
                        break;
                    }
        }


    }
}

