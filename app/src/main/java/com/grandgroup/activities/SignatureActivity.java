package com.grandgroup.activities;

import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.grandgroup.R;
import com.grandgroup.utills.CommonUtils;
import com.parse.ParseFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

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
                if (signature_pad.getVisibility() == View.VISIBLE)
                    if (signature_pad.getGesture() != null) {
                        signBitmap = Bitmap.createBitmap(signature_pad.getDrawingCache());
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        signBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

                        byte[] image = out.toByteArray();
                        ParseFile file = new ParseFile("file.png", image);
//                        Uri signature = CommonUtils.getInstance().getImageUri(mContext,signBitmap);

                        break;
                    }
        }


    }

    private String saveBitMap (Bitmap bitmap){
        String filename = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Docmein/Signature/"
                + Math.abs(new Random().nextInt()) + ".jpeg";
        File pictureFile = new File(filename);
        try {
            pictureFile.createNewFile();
            FileOutputStream oStream = new FileOutputStream(pictureFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, oStream);
            oStream.flush();
            oStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }
}

