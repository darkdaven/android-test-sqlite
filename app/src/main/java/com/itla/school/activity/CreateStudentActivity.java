package com.itla.school.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.itla.school.R;
import com.itla.school.entity.Career;
import com.itla.school.entity.Student;
import com.itla.school.repository.CareerDatabaseRepository;
import com.itla.school.repository.StudentDatabaseRepository;

import java.util.List;

public class CreateStudentActivity extends AppCompatActivity {

    private StudentDatabaseRepository studentDatabaseRepository;
    private CareerDatabaseRepository careerDatabaseRepository;
    private Spinner spCareer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);

        this.studentDatabaseRepository = new StudentDatabaseRepository(this.getBaseContext());
        this.careerDatabaseRepository = new CareerDatabaseRepository(this.getBaseContext());

        final Button btCancel = findViewById(R.id.btCancel);
        btCancel.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), StudentListActivity.class);
            startActivity(intent);
        });

        final Button btNewCareer  = findViewById(R.id.btNewCareer);
        btNewCareer.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CareerListActivity.class);
            startActivity(intent);
        });

        final EditText etName = findViewById(R.id.etName);
        final EditText etRegistrationNumber = findViewById(R.id.etRegistrationNumber);
        this.spCareer = findViewById(R.id.spCareer);

        this.setupSpinner();

        Button btSave = findViewById(R.id.btSave);
        btSave.setOnClickListener(v -> {
            if (etName.getText().toString().matches("")) {
                etName.setError("Please type a valid name");
                return;
            }

            if (etRegistrationNumber.getText().toString().matches("")) {
                etRegistrationNumber.setError("Please type a valid registration number");
                return;
            }

            if (etRegistrationNumber.getText().toString().matches("")) {
                etRegistrationNumber.setError("Please type a valid registration number");
                return;
            }

            if (spCareer.getSelectedItem() == null) {
                Toast.makeText(v.getContext(), "Please select a career", Toast.LENGTH_LONG).show();
                return;
            }

            final Career career = (Career) spCareer.getSelectedItem();

            Student student = new Student(etName.getText().toString(), etRegistrationNumber.getText().toString(), career);

            studentDatabaseRepository.create(student);

            Toast.makeText(v.getContext(), "Student have been save successfully", Toast.LENGTH_LONG).show();
            btCancel.callOnClick();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupSpinner();
    }

    private void setupSpinner() {
        List<Career> careers = this.careerDatabaseRepository.getAll();
        ArrayAdapter<Career> dataAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                careers);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCareer.setAdapter(dataAdapter);
    }
}