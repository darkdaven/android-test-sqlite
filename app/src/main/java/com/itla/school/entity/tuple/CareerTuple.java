package com.itla.school.entity.tuple;


import androidx.room.ColumnInfo;

import com.itla.school.entity.Career;

public class CareerTuple {
    @ColumnInfo(name = "career_id")
    public Integer id;

    @ColumnInfo(name = "career_name")
    public String name;

    @ColumnInfo(name = "career_subjects")
    public Integer subjects;

    @ColumnInfo(name = "career_credits")
    public Integer credits;

    public Career toCareer() {
        final Career career = new Career(this.id, this.name, this.subjects, this.credits);
        return career;
    }
}
