package com.itla.testappdb.entity;

import android.content.ContentValues;
import android.database.Cursor;

public class Subject {
    private Integer id;
    private String name;
    private Integer credits;

    public Subject(String name, Integer credits) {
        this.name = name;
        this.credits = credits;
    }

    public Subject(final Cursor cursor) {
        this.setId(cursor.getInt(cursor.getColumnIndex("id")));
        this.setName(cursor.getString(cursor.getColumnIndex("name")));
        this.setCredits(cursor.getInt(cursor.getColumnIndex("credits")));
    }

    public ContentValues contentValues() {
        final ContentValues contentValues = new ContentValues();

        contentValues.put("name", this.getName());
        contentValues.put("credits", this.getCredits());

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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
