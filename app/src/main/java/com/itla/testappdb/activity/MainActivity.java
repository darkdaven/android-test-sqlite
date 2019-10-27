package com.itla.testappdb.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Intent intent = new Intent(this.getBaseContext(), StudentListActivity.class);
        startActivity(intent);

        /*Button bStudentView = findViewById(R.id.bStudentView);

        bStudentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), StudentListActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
