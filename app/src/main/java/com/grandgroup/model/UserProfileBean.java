package com.grandgroup.model;

import android.graphics.Bitmap;
import android.net.Uri;

import com.parse.ParseFile;

import java.io.Serializable;

/**
 * Created by 1234 on 2/1/2017.
 */

public class UserProfileBean implements Serializable {
    private String userFirstName = "";
    private String userLastName = "";
    private String userPhoneNumber = "";
    private  String userBloodGroup = "";
    private String userCurrentCity = "";
    private Bitmap userImgBitmap;
    private String userProfilePicUrl;
    private  String userGender = "";
    private String userEmail = "";
    private  boolean userAvailability = true;


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public Bitmap getUserImgBitmap() {
        return userImgBitmap;
    }

    public void setUserImgBitmap(Bitmap userImgBitmap) {
        this.userImgBitmap = userImgBitmap;
    }


    public boolean isUserAvailability() {
        return userAvailability;
    }

    public void setUserAvailability(boolean userAvailability) {
        this.userAvailability = userAvailability;
    }


    public String getUserProfilePicUrl() {
        return userProfilePicUrl;
    }

    public void setUserProfilePicUrl(String userProfilePicUrl) {
        this.userProfilePicUrl = userProfilePicUrl;
    }


  /*  public ParseFile getUserImg() {
        return userImg;
    }

    public void setUserImg(ParseFile userImg) {
        this.userImg = userImg;
    }*/

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserBloodGroup() {
        return userBloodGroup;
    }

    public void setUserBloodGroup(String userBloodGroup) {
        this.userBloodGroup = userBloodGroup;
    }

    public String getUserCurrentCity() {
        return userCurrentCity;
    }

    public void setUserCurrentCity(String userCurrentCity) {
        this.userCurrentCity = userCurrentCity;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }


}