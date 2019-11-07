package com.itla.school.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.school.R;
import com.itla.school.adapter.SubjectAdapter;
import com.itla.school.entity.Career;
import com.itla.school.entity.CareerSubject;
import com.itla.school.entity.Subject;
import com.itla.school.repository.CareerDatabaseRepository;
import com.itla.school.repository.CareerSubjectDatabaseRepository;
import com.itla.school.repository.SubjectsDatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class CreateCareerActivity extends AppCompatActivity {

    private CareerDatabaseRepository careerDatabaseRepository;
    private SubjectsDatabaseRepository subjectsDatabaseRepository;
    private CareerSubjectDatabaseRepository careerSubjectDatabaseRepository;
    private Spinner spSubject;
    private List<Subject> careerSubjects;
    private SubjectAdapter subjectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_career);

        this.careerDatabaseRepository = new CareerDatabaseRepository(this.getBaseContext());
        this.subjectsDatabaseRepository = new SubjectsDatabaseRepository(this.getBaseContext());
        this.careerSubjectDatabaseRepository = new CareerSubjectDatabaseRepository(this.getBaseContext());

        this.careerSubjects = new ArrayList<>();
        this.subjectAdapter = new SubjectAdapter(careerSubjects);

        final RecyclerView rvSubjects = findViewById(R.id.rvSubjects);
        rvSubjects.setAdapter(subjectAdapter);

        rvSubjects.setLayoutManager(new LinearLayoutManager(this));

        this.spSubject = findViewById(R.id.spSubject);

        final Button btAddSubject = findViewById(R.id.btAddSubject);
        btAddSubject.setOnClickListener(v -> {
            if (spSubject.getSelectedItem() == null) {
                Toast.makeText(v.getContext(), "Please select a subject", Toast.LENGTH_LONG).show();
                return;
            }

            careerSubjects.add((Subject) spSubject.getSelectedItem());
            subjectAdapter.notifyItemInserted(careerSubjects.size() - 1);
        });

        final Button btNewSubject = findViewById(R.id.btNewSubject);
        btNewSubject.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CreateSubjectActivity.class);
            startActivity(intent);
        });

        final EditText etCareerName = findViewById(R.id.etCareerName);

        final Button btCreateCareerSave = findViewById(R.id.btCreateCareerSave);
        btCreateCareerSave.setOnClickListener(v -> {
            if (etCareerName.getText().toString().matches("")) {
                etCareerName.setError("Please type a valid name");
                return;
            }

            if (careerSubjects.isEmpty()) {
                Toast.makeText(v.getContext(), "Please add at least one subject to the list", Toast.LENGTH_LONG).show();
                return;
            }

            final Career career = new Career(etCareerName.getText().toString());
            careerDatabaseRepository.create(career);

            for (Subject s : careerSubjects) {
                CareerSubject careerSubject = new CareerSubject(career, s);
                careerSubjectDatabaseRepository.create(careerSubject);
            }

            Toast.makeText(v.getContext(), "Career have been save successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(v.getContext(), CareerListActivity.class);
            startActivity(intent);
        });
    }

    private void setupSpinner() {
        List<Subject> subjects = this.subjectsDatabaseRepository.getAll();
        ArrayAdapter<Subject> dataAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                subjects);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSubject.setAdapter(dataAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setupSpinner();
    }
}
