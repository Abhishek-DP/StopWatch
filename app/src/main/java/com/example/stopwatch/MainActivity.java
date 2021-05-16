package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView counter;
    int count;

    Handler handler = new Handler(Looper.getMainLooper());
    Runnable time_lap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = findViewById(R.id.counter);
    }

    public void start_timer(View view) {
        count = 0;
        stop_timer(view);
        time_lap = new Runnable() {
            @Override
            public void run() {
                counter.setText(String.valueOf(++count));
                handler.postDelayed(this,1000);
            }
        };
        handler.postDelayed(time_lap,1000);
    }

    public void stop_timer(View view) {
        handler.removeCallbacks(time_lap);
        counter.setText(String.valueOf(0));
    }
}