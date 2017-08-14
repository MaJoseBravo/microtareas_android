package com.example.dptoredes.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = (TextView) findViewById(R.id.textView1);
        Button start = (Button) findViewById(R.id.button1);
        //final ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        //progress.setMax(10);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //progress.setVisibility(View.VISIBLE);
                //progress.setProgress(0);
                new Thread1(text).execute(10);
            }
        });
    }
}