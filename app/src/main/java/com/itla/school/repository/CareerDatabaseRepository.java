package com.itla.school.repository;

import android.content.Context;

import com.itla.school.database.connection.AppDatabase;
import com.itla.school.entity.Career;
import com.itla.school.entity.tuple.CareerTuple;

import java.util.ArrayList;
import java.util.List;

public class CareerDatabaseRepository implements CrudRepository<Career, Integer> {

    private AppDatabase connection;

    public CareerDatabaseRepository(Context context) {
        this.connection = AppDatabase.getInstance(context);
    }

    @Override
    public Career create(Career entity) {
        long id = this.connection.careerDao().create(entity);
        entity.setId((int) id);

        return entity;
    }

    @Override
    public void update(Career entity) {
        this.connection.careerDao().update(entity);
    }

    @Override
    public void delete(Career entity) {
        this.connection.careerDao().delete(entity);
    }

    @Override
    public Career get(Integer id) {
        CareerTuple careerTuple = this.connection.careerDao().get(id);
        return careerTuple.toCareer();
    }

    @Override
    public List<Career> getAll() {
        List<CareerTuple> careerTuples = this.connection.careerDao().getAll();

        List<Career> careers = new ArrayList<>();
        for (CareerTuple tuple : careerTuples) {
            careers.add(tuple.toCareer());
        }

        return careers;
    }
}
