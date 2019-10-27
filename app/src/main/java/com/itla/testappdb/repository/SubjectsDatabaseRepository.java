package com.itla.testappdb.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.testappdb.database.connection.DatabaseConnection;
import com.itla.testappdb.entity.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectsDatabaseRepository implements CrudRepository<Subject, Integer> {

    private DatabaseConnection connection;
    private static final String TABLE_NAME = "subjects";

    public SubjectsDatabaseRepository(Context context) {
        this.connection = new DatabaseConnection(context);
    }

    @Override
    public Subject create(Subject entity) {
        final SQLiteDatabase sqLiteDatabase = this.connection.getWritableDatabase();
        final ContentValues contentValues = entity.contentValues();

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if (id == -1) {
            Log.i("CareerRepository", "Unknown error have pass trying insert career");
        } else {
            Log.i("CareerRepository", String.format("The career have been created with id %d", id));
            entity.setId((int) id);
        }

        sqLiteDatabase.close();

        return entity;
    }

    @Override
    public void update(Subject entity) {
        final SQLiteDatabase sqLiteDatabase = this.connection.getWritableDatabase();
        final ContentValues contentValues = entity.contentValues();

        sqLiteDatabase.update(TABLE_NAME, contentValues, "id = ?", new String[]{entity.getId().toString()});
        sqLiteDatabase.close();
    }

    @Override
    public void delete(Subject entity) {
        final SQLiteDatabase sqLiteDatabase = this.connection.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, "id = ?", new String[]{entity.getId().toString()});
        sqLiteDatabase.close();
    }

    @Override
    public Subject get(Integer id) {
        final SQLiteDatabase sqLiteDatabase = this.connection.getReadableDatabase();

        final Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, "id = ?",
                new String[]{id.toString()}, null, null, null);

        cursor.moveToFirst();
        Subject subject = new Subject(cursor);
        cursor.close();
        sqLiteDatabase.close();

        return subject;
    }

    @Override
    public List<Subject> getAll() {
        final SQLiteDatabase sqLiteDatabase = this.connection.getReadableDatabase();
        final Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null,
                null, null, null, null, null);

        List<Subject> subjects = new ArrayList<>();

        while (cursor.moveToNext()) {
            subjects.add(new Subject(cursor));
        }

        cursor.close();
        sqLiteDatabase.close();

        return subjects;
    }
}
