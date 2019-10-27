package com.example.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Day3 extends AppCompatActivity {
    static TextView temp,minT,maxT;
    static TextView humid,pressure,sunrise,sunset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3);
        temp = findViewById(R.id.temp3);
        minT = findViewById(R.id.min3);
        maxT = findViewById(R.id.max3);
        humid = findViewById(R.id.humid3);
        pressure = findViewById(R.id.pressure3);
        sunrise = findViewById(R.id.rise3);
        sunset = findViewById(R.id.set3);
        DownloadTask task = new DownloadTask();
        task.execute();
    }
}
