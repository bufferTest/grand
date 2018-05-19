package com.grandgroup.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.grandgroup.utills.AppConstant;

public class SQLiteQueries {
    private static SQLiteQueries mInstance = null;
    private final int ZERO = 0;
    private final String EQUALS = " = ";
    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

    private SQLiteQueries(Context _context) {
        databaseHelper = new DatabaseHelper(_context, AppConstant.DATABASE_NAME, null, AppConstant.DATABASE_VERSION);
    }

    public static SQLiteQueries getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SQLiteQueries(context.getApplicationContext());
        }
        return mInstance;
    }

    private SQLiteQueries open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
        return this;
    }
}
