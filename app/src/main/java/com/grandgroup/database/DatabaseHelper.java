package com.grandgroup.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.grandgroup.utills.AppConstant;

class DatabaseHelper extends SQLiteOpenHelper {

    DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
       /* database.execSQL("CREATE TABLE " + AppConstant.EVENTSTABLE + " ( " + AppConstant.PREVIOUSCATID + " VARCHAR ,"
                + AppConstant.CATID + " VARCHAR ," + AppConstant.PREVIOUSDOCNAME + " VARCHAR ," + AppConstant.DOCNAME
                + " VARCHAR , " + AppConstant.ISDATACHANGED + " VARCHAR);");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + AppConstant.EVENTSTABLE);
        onCreate(db);
    }
}
