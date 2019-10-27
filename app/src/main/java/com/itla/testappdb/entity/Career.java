package com.itla.testappdb.entity;

import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.NonNull;

public class Career {
    private Integer id;
    private String name;
    private Integer subjects;
    private Integer credits;

    public Career() {
    }

    public Career(Integer id) {
        this.id = id;
    }

    public Career(String name) {
        this.name = name;
    }

    public Career(final Cursor cursor) {
        this.setId(cursor.getInt(cursor.getColumnIndex("career_id")));
        this.setName(cursor.getString(cursor.getColumnIndex("career_name")));

        if (cursor.getColumnIndex("career_subjects") != -1)
            this.setSubjects(cursor.getInt(cursor.getColumnIndex("career_subjects")));
        if (cursor.getColumnIndex("career_credits") != -1)
            this.setCredits(cursor.getInt(cursor.getColumnIndex("career_credits")));
    }

    public ContentValues contentValues() {
        final ContentValues contentValues = new ContentValues();

        contentValues.put("name", this.getName());
        return contentValues;
    }

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

    public Integer getSubjects() {
        return subjects;
    }

    public void setSubjects(Integer subjects) {
        this.subjects = subjects;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getName();
    }
}
