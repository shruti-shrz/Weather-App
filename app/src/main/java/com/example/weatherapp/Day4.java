package com.example.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Day4 extends AppCompatActivity {
    static TextView temp,minT,maxT;
    static TextView humid,pressure,sunrise,sunset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day4);
        temp = findViewById(R.id.temp4);
        minT = findViewById(R.id.min4);
        maxT = findViewById(R.id.max4);
        humid = findViewById(R.id.humid4);
        pressure = findViewById(R.id.pressure4);
        sunrise = findViewById(R.id.rise4);
        sunset = findViewById(R.id.set4);
        DownloadTask task = new DownloadTask();
        task.execute();
    }
}
