package com.example.stopwatch;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    public void onClickStart(View view) {
        running = true;
    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final TextView tv = findViewById(R.id.time_view);
        final Handler hd = new Handler();
        /*hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d",hours,minutes,secs);
                Log.d("stopwatch",time);
                tv.setText(time);
                if(running){
                    seconds++;
                }
            }
        },1000);*/
        hd.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d",hours,minutes,secs);
                Log.d("stopwatch",time);
                tv.setText(time);
                if(running){
                    seconds++;
                }
                hd.postDelayed(this,1000);
            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        saveInstanceState.putInt("seconds",seconds);
        saveInstanceState.putBoolean("running",running);
        saveInstanceState.putBoolean("wasRunning",wasRunning);
    }

    public void onStop(){
        super.onStop();
        wasRunning = running;
        running = false;
    }

    public void onStart(){
        super.onStart();
        if(wasRunning){
            running = true;
        }
    }
}
