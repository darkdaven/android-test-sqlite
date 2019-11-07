package com.itla.school.repository;

import android.content.Context;

import com.itla.school.database.connection.AppDatabase;
import com.itla.school.entity.Student;
import com.itla.school.entity.tuple.StudentTuple;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabaseRepository implements CrudRepository<Student, Integer> {

    private AppDatabase connection;

    public StudentDatabaseRepository(Context context) {
        this.connection = AppDatabase.getInstance(context);
    }

    @Override
    public Student create(Student entity) {
        long id = this.connection.studentDao().create(entity);
        entity.setId((int) id);
        return entity;
    }

    @Override
    public void update(Student entity) {
        this.connection.studentDao().update(entity);
    }

    @Override
    public void delete(Student entity) {
        this.connection.studentDao().delete(entity);
    }

    @Override
    public Student get(Integer id) {
        StudentTuple tuple = this.connection.studentDao().get(id);
        return tuple.toStudent();
    }

    @Override
    public List<Student> getAll() {
        List<StudentTuple> studentTuples = this.connection.studentDao().getAll();
        List<Student> students = new ArrayList<>();

        for (StudentTuple tuple : studentTuples) {
            students.add(tuple.toStudent());
        }
        return students;
    }
}
