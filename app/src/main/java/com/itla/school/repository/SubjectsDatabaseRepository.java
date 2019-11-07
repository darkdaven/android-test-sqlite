package com.itla.school.repository;

import android.content.Context;

import com.itla.school.database.connection.AppDatabase;
import com.itla.school.entity.Subject;

import java.util.List;

public class SubjectsDatabaseRepository implements CrudRepository<Subject, Integer> {

    private AppDatabase connection;

    public SubjectsDatabaseRepository(Context context) {
        this.connection = AppDatabase.getInstance(context);
    }

    @Override
    public Subject create(Subject entity) {
        long id = this.connection.subjectDao().create(entity);
        entity.setId((int) id);

        return entity;
    }

    @Override
    public void update(Subject entity) {
        this.connection.subjectDao().update(entity);
    }

    @Override
    public void delete(Subject entity) {
        this.connection.subjectDao().delete(entity);
    }

    @Override
    public Subject get(Integer id) {
        return this.connection.subjectDao().get(id);
    }

    @Override
    public List<Subject> getAll() {
        return this.connection.subjectDao().getAll();
    }
}
