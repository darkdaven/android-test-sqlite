package com.itla.testappdb.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.testappdb.database.connection.DatabaseConnection;
import com.itla.testappdb.entity.CareerSubject;

import java.util.List;

public class CareerSubjectDatabaseRepository implements CrudRepository<CareerSubject, Integer>{

    private DatabaseConnection connection;
    private static final String TABLE_NAME = "careers_subjects";

    public CareerSubjectDatabaseRepository(Context context) {
        this.connection = new DatabaseConnection(context);
    }

    @Override
    public CareerSubject create(CareerSubject entity) {
        final SQLiteDatabase sqLiteDatabase = this.connection.getWritableDatabase();
        final ContentValues contentValues = entity.contentValues();

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if (id == -1) {
            Log.i("CareerSubjectRepository", "Unknown error have pass trying insert career subject");
        } else {
            Log.i("CareerSubjectRepository", String.format("The career subject have been created with id %d", id));
        }

        sqLiteDatabase.close();

        return entity;
    }

    @Override
    public void update(CareerSubject entity) {

    }

    @Override
    public void delete(CareerSubject entity) {

    }

    @Override
    public CareerSubject get(Integer id) {
        return null;
    }

    @Override
    public List<CareerSubject> getAll() {
        return null;
    }
}
