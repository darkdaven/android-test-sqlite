package com.itla.testappdb.database.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public final class DatabaseConnection extends SQLiteOpenHelper {

    private final static int VERSION = 1;
    private final static String DATABASE_NAME = "school.db";

    public DatabaseConnection(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table students (\n" +
                "    id INTEGER not NULL PRIMARY KEY autoincrement,\n" +
                "    name varchar not NULL,\n" +
                "    registration_number varchar not NULL\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
