package com.itla.testappdb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.testappdb.R;
import com.itla.testappdb.adapter.StudentAdapter;
import com.itla.testappdb.entity.Student;
import com.itla.testappdb.repository.StudentDatabaseRepository;

import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    private StudentDatabaseRepository studentDatabaseRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        this.studentDatabaseRepository = new StudentDatabaseRepository(this.getBaseContext());

        final List<Student> students = this.studentDatabaseRepository.getAll();
        final StudentAdapter studentAdapter = new StudentAdapter(students);

        final RecyclerView rvStudents = findViewById(R.id.rvStudent);
        rvStudents.setAdapter(studentAdapter);

        rvStudents.setLayoutManager(new LinearLayoutManager(this));

        Button btNewStudent = findViewById(R.id.btNewStudent);

        btNewStudent.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CreateStudentActivity.class);
            startActivity(intent);
        });
    }
}
