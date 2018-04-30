package com.grandgroup.utills;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.grandgroup.R;
import com.grandgroup.adapter.EventsAdapter;
import com.grandgroup.adapter.SelectItemAdapter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

/*
 * Created by softuvo on 25/1/18.
 */

public class CommonUtils {

    String itemSelected;

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


    public void selectDialog(final AppCompatActivity mContext, final OnClickItem onClickItem) {

        final Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_select_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        ImageView iv_close = dialog.findViewById(R.id.iv_close);
        RecyclerView rv_items = dialog.findViewById(R.id.rv_items);

        ArrayList<String> daysList = new ArrayList<>();
        daysList.add("Birthday");
        daysList.add("Marriage");
        daysList.add("Blood donation");
        daysList.add("Social Service");

        SelectItemAdapter adapter = new SelectItemAdapter(daysList, new SelectItemAdapter.OnClick() {
            @Override
            public void OnClick(String item) {
                itemSelected = item;
                onClickItem.OnClickItem(itemSelected);
                dialog.cancel();
            }
        });
        rv_items.setHasFixedSize(true);
        rv_items.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rv_items.setLayoutManager(llm);


        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.cancel();
            }
        });

        dialog.show();
    }

    public interface OnClickItem {
        void OnClickItem(String Item);
    }

}
