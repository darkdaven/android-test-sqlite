package com.itla.school.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.itla.school.entity.CareerSubject;

@Dao
public interface CareerSubjectDao {

    @Insert
    long create(CareerSubject entity);

    @Update
    void update(CareerSubject entity);

    @Delete
    void delete(CareerSubject... entity);
}
