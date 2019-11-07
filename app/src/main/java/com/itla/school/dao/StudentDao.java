package com.itla.school.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.itla.school.entity.Student;
import com.itla.school.entity.tuple.StudentTuple;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    long create(Student entity);

    @Update
    void update(Student entity);

    @Delete
    void delete(Student... entity);

    @Query("SELECT " +
            "   s.id as student_id, s.name as student_name, " +
            "   s.registration_number as student_registration_number, " +
            "   c.id as career_id, c.name as career_name " +
            "FROM " +
            "   students s " +
            "   LEFT JOIN careers c on (c.id = s.career_id) " +
            "WHERE " +
            "s.id = :id")
    StudentTuple get(Integer id);

    @Query("SELECT " +
            "   s.id as student_id, s.name as student_name, " +
            "   s.registration_number as student_registration_number, " +
            "   c.id as career_id, c.name as career_name " +
            "FROM " +
            "   students s " +
            "   LEFT JOIN careers c on (c.id = s.career_id)")
    List<StudentTuple> getAll();
}
