package com.itla.school.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.itla.school.entity.Subject;

import java.util.List;

@Dao
public interface SubjectDao {
    @Insert
    long create(Subject entity);

    @Update
    void update(Subject entity);

    @Delete
    void delete(Subject... entity);

    @Query("select * from subjects where id = :id")
    Subject get(Integer id);

    @Query("select * from subjects")
    List<Subject> getAll();
}
