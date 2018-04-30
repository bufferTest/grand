package com.grandgroup.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.grandgroup.R;
import com.grandgroup.model.UserProfileBean;
import com.grandgroup.utills.AppConstant;
import com.grandgroup.utills.AppPrefrence;
import com.grandgroup.utills.GrandGroupHelper;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;

public class LoginActivity extends AppCompatActivity {
    private GradientDrawable bgShape;
    private AppCompatActivity mContext;

    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.cl_username_pswd)
    ConstraintLayout clUserNamePswd;

    @BindView(R.id.cb_remember_me)
    CheckBox cbRememberMe;

    @BindView(R.id.et_username)
    EditText etUserName;

    @BindView(R.id.et_pswd)
    EditText etPswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ButterKnife.bind(this);
        mContext = LoginActivity.this;

        // set backgroud color to drawable
        bgShape = (GradientDrawable) btnLogin.getBackground();
        bgShape.setColor(getResources().getColor(R.color.colorButton));

        bgShape = (GradientDrawable) clUserNamePswd.getBackground();
        bgShape.setColor(getResources().getColor(R.color.colorWhite));
        setIntialData();
    }

    @OnClick({R.id.btn_login, R.id.cb_remember_me, R.id.forgot_password})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (cbRememberMe.isChecked()) {
                    AppPrefrence.init(mContext).putBoolean(AppConstant.IS_REMEMBERED, true);
                    AppPrefrence.init(mContext).putString(AppConstant.USER_NAME, etUserName.getText().toString());
                    AppPrefrence.init(mContext).putString(AppConstant.USER_PSWD, etPswd.getText().toString());
                }

                loginUser();
                break;

            case R.id.cb_remember_me:
                if (!cbRememberMe.isChecked()) {
                        AppPrefrence.init(mContext).putBoolean(AppConstant.IS_REMEMBERED, true);
                        AppPrefrence.init(mContext).putString(AppConstant.USER_NAME,"");
                        AppPrefrence.init(mContext).putString(AppConstant.USER_PSWD,"");
                    }
                break;

            case R.id.forgot_password:

                break;
        }
    }

    private void loginUser() {
        ParseUser.logInInBackground(etUserName.getText().toString(), etPswd.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, com.parse.ParseException e) {
                if (user != null) {
                    ParseUser parseUser = ParseUser.getCurrentUser();

                    parseUser.getParseObject("User").fetchIfNeededInBackground(new GetCallback<ParseObject>() {

                        @Override
                        public void done(ParseObject object, com.parse.ParseException e) {
                            UserProfileBean userProfileBean = new UserProfileBean();
                            if (e == null) {
                                AppPrefrence.init(mContext).putBoolean(AppConstant.IS_LOGGED_IN,true);
                                //  BloodDonationHelper.bloodDonationHelper(mContext).dismissLoader();
                            userProfileBean.setUserFirstName(object.getString(getString(R.string.userFirstName)));
                            userProfileBean.setUserLastName(object.getString(getString(R.string.userLastName)));
                            userProfileBean.setUserPhoneNumber(object.getString(getString(R.string.userEmail)));
                            userProfileBean.setUserBloodGroup(object.getString(getString(R.string.userPassword)));
                            userProfileBean.setUserAvailability(object.getBoolean(getString(R.string.isAdmin)));

                            ParseFile postImage = object.getParseFile(getString(R.string.profilePic));
                            if (postImage != null)
                                userProfileBean.setUserProfilePicUrl(postImage.getUrl());
                            else
                                userProfileBean.setUserProfilePicUrl("");

                            Gson gson = new Gson();
                            String json = gson.toJson(userProfileBean);
                           AppPrefrence.init(mContext).putString(AppConstant.USER_PROFILE,json);
                                startActivity(new Intent(mContext, DashBoardActivity.class));
                                mContext.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                                finish();

                            } else {
                                //  BloodDonationHelper.bloodDonationHelper(mContext).dismissLoader();
                                Toast.makeText(getApplicationContext(), "Invalid email or password!", Toast.LENGTH_LONG).show();

                            }
                        }

                    });


                } else {
                    // GrandGroupHelper.grandGroupHelper(mContext).d();
                    Toast.makeText(getApplicationContext(),"Invalid email or password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void setIntialData() {
        if (AppPrefrence.init(mContext).getBoolean(AppConstant.IS_REMEMBERED)) {
            cbRememberMe.setChecked(true);
            etUserName.setText(AppPrefrence.init(mContext).getString(AppConstant.USER_NAME));
            etPswd.setText(AppPrefrence.init(mContext).getString(AppConstant.USER_PSWD));
        }

    }

}

