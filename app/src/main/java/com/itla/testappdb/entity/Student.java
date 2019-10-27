package com.itla.testappdb.entity;

import android.content.ContentValues;
import android.database.Cursor;

public class Student {

    private Integer id;
    private String name;
    private String registrationNumber;
    private Career career;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Student(){}

    public Student(String name, String registrationNumber, Career career) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.career = career;
    }

    public Student(final Cursor cursor) {
        this.setId(cursor.getInt(cursor.getColumnIndex("student_id")));
        this.setName(cursor.getString(cursor.getColumnIndex("student_name")));
        this.setRegistrationNumber(cursor.getString(cursor.getColumnIndex("student_registration_number")));
        this.career = new Career(cursor);
    }

    public ContentValues contentValues() {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("name", this.getName());
        contentValues.put("registration_number", this.getRegistrationNumber());
        contentValues.put("career_id", this.getCareer().getId());

        return contentValues;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
