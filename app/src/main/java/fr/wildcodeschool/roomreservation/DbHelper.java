package fr.wildcodeschool.roomreservation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wilder on 03/04/18.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_PERSON_ENTRIES =
            "CREATE TABLE " + DbContract.PersonEntry.TABLE_NAME + " (" +
                    DbContract.PersonEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    DbContract.PersonEntry.COLUMN_NAME_LASTNAME + " TEXT," +
                    DbContract.PersonEntry.COLUMN_NAME_FIRSTNAME + " TEXT);";

    public static final String SQL_CREATE_ROOM_ENTRIES =
            "CREATE TABLE " + DbContract.RoomEntry.TABLE_NAME + " (" +
                    DbContract.RoomEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    DbContract.RoomEntry.COLUMN_NAME_ROOM + " TEXT)";


    public static final String SQL_DELETE_PERSON_ENTRIES =
            "DROP TABLE IF EXISTS " + DbContract.PersonEntry.TABLE_NAME;

    public static final String SQL_DELETE_ROOM_ENTRIES =
            "DROP TABLE IF EXISTS " + DbContract.RoomEntry.TABLE_NAME;


    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "database.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_PERSON_ENTRIES);
        db.execSQL(SQL_CREATE_ROOM_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PERSON_ENTRIES);
        db.execSQL(SQL_DELETE_ROOM_ENTRIES);

        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }



}
