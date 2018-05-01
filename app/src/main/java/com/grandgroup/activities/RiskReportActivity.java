package com.grandgroup.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.grandgroup.R;
import com.grandgroup.utills.CommonUtils;
import com.grandgroup.utills.PermissionUtils;
import com.grandgroup.views.CustomDateDialog;
import com.grandgroup.views.CustomTimeDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.grandgroup.utills.AppConstant.CAMERA_PERMISSIONS_REQUEST;
import static com.grandgroup.utills.AppConstant.CAMERA_REQUEST;
import static com.grandgroup.utills.AppConstant.GALLERY_PERMISSIONS_REQUEST;
import static com.grandgroup.utills.AppConstant.GALLERY_REQUEST;
import static com.grandgroup.utills.AppConstant.WRITE_PERMISSIONS_REQUEST;

public class RiskReportActivity extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_event_date)
    TextView tv_event_date;
    @BindView(R.id.iv_image)
    ImageView iv_image;
    @BindView(R.id.tv_select_likelihood)
    TextView tvSelectedLikelihood;
    @BindView(R.id.tv_select_consq)
    TextView tv_select_consq;
    @BindView(R.id.et_control_eff)
    TextView et_control_eff;
    @BindView(R.id.lay_screenshot)
    ConstraintLayout lay_screenshot;
    private AppCompatActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_report);
        setInitialData();
    }

    @OnClick({R.id.btn_back, R.id.tv_event_date, R.id.lay_photo, R.id.tv_select_likelihood, R.id.tv_select_consq,
            R.id.et_control_eff, R.id.btn_email})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                mContext.overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
                break;
            case R.id.tv_event_date:
                CustomDateDialog.getInstance().DatePicker(mContext, new CustomDateDialog.DateDialogListener() {
                    @Override
                    public void onOkayClick(int date, int month, int year) {
                        CustomTimeDialog.getInstance().timePicker(mContext, new CustomTimeDialog.TimeDialogListener() {
                            @Override
                            public void onOkayClick(String twentyFourTime, String TwelveHourTime) {

                            }
                        });
                    }
                });
                break;
            case R.id.lay_photo:
                selectImage();
                break;
            case R.id.tv_select_likelihood:
                CommonUtils.getInstance().selectDialog(mContext, new CommonUtils.OnClickItem() {
                    @Override
                    public void OnClickItem(String Item) {
                        tvSelectedLikelihood.setText(Item);
                    }
                });
                break;
            case R.id.tv_select_consq:
                CommonUtils.getInstance().selectDialog(mContext, new CommonUtils.OnClickItem() {
                    @Override
                    public void OnClickItem(String Item) {
                        tv_select_consq.setText(Item);
                    }
                });
                break;
            case R.id.et_control_eff:
                CommonUtils.getInstance().selectDialog(mContext, new CommonUtils.OnClickItem() {
                    @Override
                    public void OnClickItem(String Item) {
                        et_control_eff.setText(Item);
                    }
                });
                break;
            case R.id.btn_email:
                if (PermissionUtils.requestPermission(mContext, WRITE_PERMISSIONS_REQUEST, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    createSendForm();
                }

                break;
        }

    }

    private void setInitialData() {
        mContext = RiskReportActivity.this;
        ButterKnife.bind(mContext);
        tvTitle.setText("Risk / Hazard Report");
    }


    private void selectImage() {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Add Photo!");
        builder.setItems(options,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (options[item].equals("Take Photo")) {
                            if (PermissionUtils.requestPermission(mContext, CAMERA_PERMISSIONS_REQUEST, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)) {
                                startCamera();
                            }
                        } else if (options[item].equals("Choose from Gallery")) {
                            if (PermissionUtils.requestPermission(mContext, GALLERY_PERMISSIONS_REQUEST, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                                GalleryIntent();
                            }

                        } else if (options[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {


                if (data != null) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");

                    Uri tempUri = CommonUtils.getInstance().getImageUri(mContext, thumbnail);
                    Glide.with(mContext).load(tempUri).into(iv_image);
                }

            } else if (requestCode == GALLERY_REQUEST) {
                if (data != null) {
                    Bitmap bitmap = null;
                    try {
                        Uri tempUri = data.getData();
                        Glide.with(mContext).load(tempUri).into(iv_image);
                       /* bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), tempUri);
                        iv_image.setImageBitmap(bitmap);*/
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_PERMISSIONS_REQUEST:
                if (PermissionUtils.permissionGranted(requestCode, CAMERA_PERMISSIONS_REQUEST, grantResults)) {
                    startCamera();
                }
            case GALLERY_PERMISSIONS_REQUEST:
                if (PermissionUtils.permissionGranted(requestCode, CAMERA_PERMISSIONS_REQUEST, grantResults)) {
                    GalleryIntent();
                }
                break;
            case WRITE_PERMISSIONS_REQUEST:
                if (PermissionUtils.permissionGranted(requestCode, WRITE_PERMISSIONS_REQUEST, grantResults)) {
                    createSendForm();
                }
                break;
        }
    }

    private void startCamera() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_SCREEN_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    private void GalleryIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST);
    }

    private void createSendForm() {
        Uri uri = CommonUtils.getInstance().createPdf(lay_screenshot, "Risk_Report_Form");

        ShareCompat.IntentBuilder.from(mContext)
                .setType("message/rfc822")
                .setSubject("Risk Report Form")
                .setText("Risk Report Form.")
                .setStream(uri)
                .setChooserTitle("Share Form")
                .startChooser();
    }

}
