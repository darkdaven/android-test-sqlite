package com.itla.school.repository;

import android.content.Context;

import com.itla.school.database.connection.AppDatabase;
import com.itla.school.entity.CareerSubject;

import java.util.List;

public class CareerSubjectDatabaseRepository implements CrudRepository<CareerSubject, Integer> {

    private AppDatabase connection;

    public CareerSubjectDatabaseRepository(Context context) {
        this.connection = AppDatabase.getInstance(context);
    }

    @Override
    public CareerSubject create(CareerSubject entity) {
        this.connection.careerSubjectDao().create(entity);
        return entity;
    }

    @Override
    public void update(CareerSubject entity) {
        this.connection.careerSubjectDao().update(entity);
    }

    @Override
    public void delete(CareerSubject entity) {
        this.connection.careerSubjectDao().delete(entity);
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
