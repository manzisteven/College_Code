package com.example.smanzi.rbc.OfflineMode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by smanzi on 6/16/2015.
 */
public class OfflineDatabase extends SQLiteOpenHelper {


    private static final String DB_NAME = "OFFLINE.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NOTIFICATION_OFFLINE_STORE = "notification_offline_store";
    public static final String TABLE_INVESTIGATION_OFFLINE_STORE = "investigation_offline_store";
    public static final String TABLE_FOCI_OFFLINE_STORE = "foci_offline_store";
    public static final String TABLE_CASEFOLLOWUP_OFFLINE_STORE = "caseFollowUp_offline_store";
    public static final String COLUMN_OBJECT = "object";
    public static final String COLUMN_OFFLINE_ID = "oID";

    private static String CREATE_NOTIFICATION_TABLE =
            "CREATE TABLE " + TABLE_NOTIFICATION_OFFLINE_STORE + "("
                    + COLUMN_OFFLINE_ID + " INTEGER NOT NULL PRIMARY KEY," +
                    COLUMN_OBJECT +" TEXT)";
    private static String CREATE_INVESTIGATION_TABLE =
            "CREATE TABLE " + TABLE_INVESTIGATION_OFFLINE_STORE + "("
                    + COLUMN_OFFLINE_ID + " INTEGER NOT NULL PRIMARY KEY," +
                    COLUMN_OBJECT +" TEXT)";

    private static String CREATE_FOCI_TABLE =
            "CREATE TABLE " + TABLE_FOCI_OFFLINE_STORE + "("
                    + COLUMN_OFFLINE_ID + " INTEGER NOT NULL PRIMARY KEY," +
                    COLUMN_OBJECT +" TEXT)";
    private static String CREATE_CaseFollowUp_TABLE =
            "CREATE TABLE " + TABLE_CASEFOLLOWUP_OFFLINE_STORE + "("
                    + COLUMN_OFFLINE_ID + " INTEGER NOT NULL PRIMARY KEY," +
                    COLUMN_OBJECT +" TEXT)";
    private static OfflineDatabase sSQLiteHelper;

    public static OfflineDatabase getInstance(Context context) {

        // don't leak an Activity's context.
        if (sSQLiteHelper == null) {
            sSQLiteHelper = new OfflineDatabase(context.getApplicationContext());
        }
        return sSQLiteHelper;
    }
    public OfflineDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_NOTIFICATION_TABLE);
        db.execSQL(CREATE_INVESTIGATION_TABLE);
        db.execSQL(CREATE_CaseFollowUp_TABLE);
        db.execSQL(CREATE_FOCI_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATION_OFFLINE_STORE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INVESTIGATION_OFFLINE_STORE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOCI_OFFLINE_STORE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CASEFOLLOWUP_OFFLINE_STORE);
        onCreate(db);
    }


    public void InsertNotification(String notification_object)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues notification = new ContentValues();

        notification.put(COLUMN_OBJECT, notification_object);

        db.insert(TABLE_NOTIFICATION_OFFLINE_STORE,null,notification);
        db.close();

    }

    public void InsertInvestigation(String investigation_object)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues notification = new ContentValues();

        notification.put(COLUMN_OBJECT, investigation_object);

        db.insert(TABLE_INVESTIGATION_OFFLINE_STORE,null,notification);
        db.close();

    }

    public void InsertFoci(String notification_object)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues notification = new ContentValues();

        notification.put(COLUMN_OBJECT, notification_object);

        db.insert(TABLE_FOCI_OFFLINE_STORE,null,notification);
        db.close();

    }
    public void InsertCaseFollowUp(String notification_object)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues notification = new ContentValues();

        notification.put(COLUMN_OBJECT, notification_object);

        db.insert(TABLE_CASEFOLLOWUP_OFFLINE_STORE,null,notification);
        db.close();

    }

    public ArrayList<String> retrieveInvestigation()
    {
        ArrayList allObjects = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + TABLE_INVESTIGATION_OFFLINE_STORE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

       while (!cursor.isAfterLast()) {


           String object = cursor.getString(cursor.getColumnIndex(COLUMN_OBJECT));
           allObjects.add(object);
           Log.d("retDatabase", "I just Added");
           cursor.moveToNext();
       }
        cursor.deactivate();
        db.close();
        return allObjects;
    }
    public ArrayList<String> retrieveCaseFollowUp()
    {
        ArrayList allObjects = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + TABLE_CASEFOLLOWUP_OFFLINE_STORE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {


            String object = cursor.getString(cursor.getColumnIndex(COLUMN_OBJECT));
            allObjects.add(object);
            Log.d("retDatabase", "I just Added");
            cursor.moveToNext();
        }
        cursor.deactivate();
        db.close();
        return allObjects;
    }
    public ArrayList<String> retrieveFOCI()
    {
        ArrayList allObjects = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + TABLE_FOCI_OFFLINE_STORE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {


            String object = cursor.getString(cursor.getColumnIndex(COLUMN_OBJECT));
            allObjects.add(object);
            Log.d("retDatabase", "I just Added");
            cursor.moveToNext();
        }
        cursor.deactivate();
        db.close();
        return allObjects;
    }
    public ArrayList<String> retrieveNotification()
    {
        ArrayList allObjects = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + TABLE_NOTIFICATION_OFFLINE_STORE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {


            String object = cursor.getString(cursor.getColumnIndex(COLUMN_OBJECT));
            allObjects.add(object);
            Log.d("retDatabase", "I just Added");
            cursor.moveToNext();
        }
        cursor.deactivate();
        db.close();
        return allObjects;
    }
    }

