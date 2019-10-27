package com.itla.testappdb.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.testappdb.R;
import com.itla.testappdb.adapter.CareerAdapter;
import com.itla.testappdb.entity.Career;
import com.itla.testappdb.repository.CareerDatabaseRepository;

import java.util.List;

public class CareerListActivity extends AppCompatActivity {

    private CareerDatabaseRepository careerDatabaseRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_list);

        this.careerDatabaseRepository = new CareerDatabaseRepository(this.getBaseContext());

        final List<Career> careers = this.careerDatabaseRepository.getAll();
        final CareerAdapter careerAdapter = new CareerAdapter(careers);

        final RecyclerView rvCareer = findViewById(R.id.rvCareer);
        rvCareer.setAdapter(careerAdapter);

        rvCareer.setLayoutManager(new LinearLayoutManager(this));

        Button btNewCareer = findViewById(R.id.btCreateCareer);

        btNewCareer.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CreateCareerActivity.class);
            startActivity(intent);
        });
    }
}
