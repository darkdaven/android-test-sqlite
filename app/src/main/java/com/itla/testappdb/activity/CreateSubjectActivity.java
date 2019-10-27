package com.itla.testappdb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itla.testappdb.R;
import com.itla.testappdb.entity.Career;
import com.itla.testappdb.entity.Student;
import com.itla.testappdb.entity.Subject;
import com.itla.testappdb.repository.SubjectsDatabaseRepository;

public class CreateSubjectActivity extends AppCompatActivity {

    private SubjectsDatabaseRepository subjectsDatabaseRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_subject);

        this.subjectsDatabaseRepository = new SubjectsDatabaseRepository(this.getBaseContext());

        final EditText etSubjectName = findViewById(R.id.etSubjectName);
        final EditText etSubjectCredits = findViewById(R.id.etSubjectCredits);

        final Button btSaveSubject = findViewById(R.id.btSaveSubject);
        btSaveSubject.setOnClickListener(v -> {
            if (etSubjectName.getText().toString().matches("")) {
                etSubjectName.setError("Please type a valid name");
                return;
            }

            if (etSubjectCredits.getText().toString().matches("")) {
                etSubjectCredits.setError("Please type a valid credits number");
                return;
            }

            Subject subject = new Subject(etSubjectName.getText().toString(), Integer.parseInt(etSubjectCredits.getText().toString()));

            subjectsDatabaseRepository.create(subject);

            Toast.makeText(v.getContext(), "Subject have been save successfully", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(v.getContext(), CreateCareerActivity.class);
            startActivity(intent);
        });
    }
}
