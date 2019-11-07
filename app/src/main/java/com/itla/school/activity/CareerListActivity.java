package com.itla.school.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.school.R;
import com.itla.school.adapter.CareerAdapter;
import com.itla.school.entity.Career;
import com.itla.school.repository.CareerDatabaseRepository;

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
