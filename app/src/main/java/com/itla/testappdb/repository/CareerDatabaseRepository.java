package com.itla.testappdb.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.testappdb.database.connection.DatabaseConnection;
import com.itla.testappdb.entity.Career;

import java.util.ArrayList;
import java.util.List;

public class CareerDatabaseRepository implements CrudRepository<Career, Integer> {

    private DatabaseConnection connection;
    private static final String TABLE_NAME = "careers";

    public CareerDatabaseRepository(Context context) {
        this.connection = new DatabaseConnection(context);
    }

    @Override
    public Career create(Career entity) {
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
    public void update(Career entity) {
        final SQLiteDatabase sqLiteDatabase = this.connection.getWritableDatabase();
        final ContentValues contentValues = entity.contentValues();

        sqLiteDatabase.update(TABLE_NAME, contentValues, "id = ?", new String[]{entity.getId().toString()});
        sqLiteDatabase.close();
    }

    @Override
    public void delete(Career entity) {
        final SQLiteDatabase sqLiteDatabase = this.connection.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, "id = ?", new String[]{entity.getId().toString()});
        sqLiteDatabase.close();
    }

    @Override
    public Career get(Integer id) {
        final SQLiteDatabase sqLiteDatabase = this.connection.getReadableDatabase();

        final Cursor cursor = sqLiteDatabase.rawQuery("SELECT c.id as career_id, " +
                "c.name as career_name, count(s.id) as career_subjects, " +
                "sum(s.credits) as career_credits " +
                "FROM careers c " +
                "inner join careers_subjects cs on (cs.career_id = c.id)" +
                "inner join subjects s on (s.id = cs.subject_id)" +
                "WHERE " +
                "c.id = ?" +
                "group by c.id, c.name", new String[]{id.toString()});

        cursor.moveToFirst();
        Career career = new Career(cursor);
        cursor.close();
        sqLiteDatabase.close();

        return career;
    }

    @Override
    public List<Career> getAll() {
        final SQLiteDatabase sqLiteDatabase = this.connection.getReadableDatabase();
        final Cursor cursor = sqLiteDatabase.rawQuery("SELECT c.id as career_id, " +
                "c.name as career_name, count(s.id) as career_subjects, " +
                "sum(s.credits) as career_credits " +
                "FROM careers c " +
                "inner join careers_subjects cs on (cs.career_id = c.id) " +
                "inner join subjects s on (s.id = cs.subject_id) " +
                "group by c.id, c.name", null);

        List<Career> careers = new ArrayList<>();

        while (cursor.moveToNext()) {
            careers.add(new Career(cursor));
        }

        cursor.close();
        sqLiteDatabase.close();

        return careers;
    }
}
