package com.itla.school.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.school.R;
import com.itla.school.adapter.StudentAdapter;
import com.itla.school.entity.Student;
import com.itla.school.repository.StudentDatabaseRepository;

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
