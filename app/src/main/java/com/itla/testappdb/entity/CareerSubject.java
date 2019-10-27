package com.itla.testappdb.entity;

import android.content.ContentValues;

public class CareerSubject {

    private Career career;
    private Subject subject;

    public CareerSubject() {
    }

    public CareerSubject(Career career, Subject subject) {
        this.career = career;
        this.subject = subject;
    }

    public ContentValues contentValues() {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("career_id", this.getCareer().getId());
        contentValues.put("subject_id", this.getSubject().getId());

        return contentValues;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
