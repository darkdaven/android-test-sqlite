package com.itla.testappdb.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.testappdb.database.connection.DatabaseConnection;
import com.itla.testappdb.entity.Student;

import java.util.List;

public class StudentDatabaseRepository implements CrudRepository<Student> {

    private DatabaseConnection connection;

    public StudentDatabaseRepository(Context context) {
        this.connection = new DatabaseConnection(context);
    }

    @Override
    public Student create(Student entity) {
        SQLiteDatabase sqLiteDatabase = this.connection.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", entity.getName());
        contentValues.put("registration_number", entity.getRegistrationNumber());

        long id = sqLiteDatabase.insert("students", null, contentValues);

        if (id == -1) {
            Log.i("StudentRepository", "Unknown error have pass trying insert student");
        } else {
            Log.i("StudentRepository", String.format("The student have been created with id %d", id));
            entity.setId((int) id);
        }

        return entity;
    }

    @Override
    public void update(Student entity) {
    }

    @Override
    public void delete(Student entity) {

    }

    @Override
    public Student get() {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
