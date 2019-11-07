package com.itla.school.entity.tuple;

import androidx.room.ColumnInfo;

import com.itla.school.entity.Career;
import com.itla.school.entity.Student;

public class StudentTuple {

    @ColumnInfo(name = "student_id")
    public Integer id;

    @ColumnInfo(name = "student_name")
    public String name;

    @ColumnInfo(name = "student_registration_number")
    public String registrationNumber;

    @ColumnInfo(name = "career_id")
    public Integer careerId;

    @ColumnInfo(name = "career_name")
    public String careerName;

    public Student toStudent() {
        final Student student = new Student();
        student.setId(this.id);
        student.setName(this.name);
        student.setRegistrationNumber(this.registrationNumber);
        student.setCareerId(this.careerId);
        student.setCareer(new Career(this.careerId, this.careerName));
        return student;
    }
}
