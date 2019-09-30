package com.itla.testappdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.itla.testappdb.entity.Student;
import com.itla.testappdb.repository.StudentDatabaseRepository;

public class MainActivity extends AppCompatActivity {

    private StudentDatabaseRepository studentDatabaseRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.studentDatabaseRepository = new StudentDatabaseRepository(this.getBaseContext());

        Student student = new Student();
        student.setName("Juan de los palotes");
        student.setRegistrationNumber("MAT-0001");

        studentDatabaseRepository.create(student);

        Student student2 = new Student();
        student2.setName("Juana de las matas");
        student2.setRegistrationNumber("MAT-0003");

        studentDatabaseRepository.create(student2);
    }
}
