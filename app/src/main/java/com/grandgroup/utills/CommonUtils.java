package com.grandgroup.utills;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.io.ByteArrayOutputStream;
import java.io.File;

/*
 * Created by softuvo on 25/1/18.
 */

public class CommonUtils {
    private static final CommonUtils ourInstance = new CommonUtils();

    private CommonUtils() {
    }

    public static CommonUtils getInstance() {
        return ourInstance;
    }

    public Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            bgDrawable.draw(canvas);
        } else {
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnedBitmap;
    }

    public void hideKeyboard(AppCompatActivity mContext) {
        View view = mContext.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public Uri getImageUri(Context inContext, Bitmap inImage) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures");
        if (!file.exists()) {
            file.mkdir();
        }
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Contact", null);
        return Uri.parse(path);
    }


    public boolean checkAndRequestPermission(Activity activity, String permission, int REQUEST_CODE) {
        if (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(activity,
                    new String[]{permission},
                    REQUEST_CODE);
            return false;
        }
    }


}
