package com.itla.school.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "careers")
public class Career {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "subjects")
    private Integer subjects;

    @ColumnInfo(name = "credits")
    private Integer credits;

    @Ignore
    public Career(Integer id) {
        this.id = id;
    }

    @Ignore
    public Career(String name) {
        this.name = name;
    }

    public Career(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Ignore
    public Career(Integer id, String name, Integer subjects, Integer credits) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.credits = credits;
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
