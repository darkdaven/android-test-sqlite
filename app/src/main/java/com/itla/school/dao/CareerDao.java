package com.itla.school.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.itla.school.entity.Career;
import com.itla.school.entity.tuple.CareerTuple;

import java.util.List;

@Dao
public interface CareerDao {

    @Insert
    long create(Career entity);

    @Update
    void update(Career entity);

    @Delete
    void delete(Career... entity);

    @Query("SELECT " +
            "   c.id as career_id, " +
            "   c.name as career_name, count(s.id) as career_subjects, " +
            "   sum(s.credits) as career_credits " +
            "FROM " +
            "   careers c " +
            "   inner join careers_subjects cs on (cs.career_id = c.id)" +
            "   inner join subjects s on (s.id = cs.subject_id)" +
            "WHERE " +
            "   c.id = :id " +
            "group by c.id, c.name")
    CareerTuple get(Integer id);

    @Query("SELECT " +
            "   c.id as career_id, " +
            "   c.name as career_name, count(s.id) as career_subjects, " +
            "   sum(s.credits) as career_credits " +
            "FROM " +
            "   careers c " +
            "   inner join careers_subjects cs on (cs.career_id = c.id) " +
            "   inner join subjects s on (s.id = cs.subject_id) " +
            "group by c.id, c.name")
    List<CareerTuple> getAll();
}
