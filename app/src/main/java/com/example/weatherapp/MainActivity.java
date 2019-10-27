package com.example.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView date,temp,minT,maxT,desc;
   static TextView humid,pressure,sunrise,sunset,wind;
   static Button b ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = findViewById(R.id.date);
        temp = findViewById(R.id.temp);
        minT = findViewById(R.id.min);
        maxT = findViewById(R.id.max);
        desc = findViewById(R.id.des);
        humid = findViewById(R.id.humidt);
        pressure = findViewById(R.id.pressuret);
        sunrise = findViewById(R.id.sunt);
        sunset = findViewById(R.id.sett);
        wind = findViewById(R.id.windt);
        b = findViewById(R.id.bu);
        final Intent i = new Intent(this,Days.class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(i);
            }
        });
        DownloadTask task = new DownloadTask();
        task.execute();

    }

}
