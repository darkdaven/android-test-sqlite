package com.itla.testappdb.database.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public final class DatabaseConnection extends SQLiteOpenHelper {

    private final static int VERSION = 3;
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

        if (newVersion == 2) {

            Log.i("CareerTableCreation", "Creating table careers");

            db.execSQL("create table if not exists careers (\n" +
                    "    id INTEGER not NULL PRIMARY KEY autoincrement,\n" +
                    "    name varchar not NULL,\n" +
                    "    subjects INTEGER not NULL,\n" +
                    "    credits INTEGER not NULL \n" +
                    ");");

            Log.i("StudentsTableUpdate", "Adding Students table fields");

            db.execSQL("alter table students add column career_id integer;");

        }

        if (newVersion == 3) {

            db.execSQL("drop table careers;");

            db.execSQL("create table if not exists careers (\n" +
                    "    id INTEGER not NULL PRIMARY KEY autoincrement,\n" +
                    "    name varchar not NULL\n" +
                    ");");

            Log.i("SubjectTableCreation", "Creating table subjects");

            db.execSQL("create table if not exists subjects (\n" +
                    "    id INTEGER not NULL PRIMARY KEY autoincrement,\n" +
                    "    name varchar not NULL,\n" +
                    "    credits INTEGER not NULL \n" +
                    ");");


            db.execSQL("create table if not exists careers_subjects (\n" +
                    "    career_id INTEGER not NULL,\n" +
                    "    subject_id INTEGER not NULL\n" +
                    ");");
        }
    }
}
