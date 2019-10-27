package com.example.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Day2 extends AppCompatActivity {
    static TextView temp,minT,maxT;
    static TextView humid,pressure,sunrise,sunset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2);
        temp = findViewById(R.id.temp2);
        minT = findViewById(R.id.min2);
        maxT = findViewById(R.id.max2);
        humid = findViewById(R.id.humid2);
        pressure = findViewById(R.id.pressure2);
        sunrise = findViewById(R.id.rise2);
        sunset = findViewById(R.id.set2);
        DownloadTask task = new DownloadTask();
        task.execute();

    }
}
