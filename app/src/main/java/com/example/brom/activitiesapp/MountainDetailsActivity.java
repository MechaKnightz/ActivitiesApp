package com.example.brom.activitiesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MountainDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountaindetails);

        Intent intent = getIntent();

        //get data from intent
        String name = intent.getStringExtra("mtName");
        String location = intent.getStringExtra("mtLocation");
        int height = intent.getIntExtra("mtHeight", 0);

        String out = "Name: " + name + "\nLocation: " + location
                + "\nHeight: " + height + "m";

        //put the obtained data in the text card view
        TextView card = findViewById(R.id.info_text);
        card.setText(out);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
