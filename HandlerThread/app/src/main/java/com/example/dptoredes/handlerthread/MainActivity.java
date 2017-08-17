package com.example.dptoredes.handlerthread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = (TextView) findViewById(R.id.textView1);
        final TextView textProgress = (TextView) findViewById(R.id.textProgress);
        Button start = (Button) findViewById(R.id.button1);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new Thread1(text,progressBar,textProgress).execute(10);
            }
        });
    }*/

    private Handler mUiHandler = new Handler();
    private MyHandlerThread mWorkerThread;
    private TextView text, progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mWorkerThread = new MyHandlerThread("myWorkerThread");
        Runnable task = new Runnable() {
            @Override
            public void run() {
                final BigInteger number = PrimeNUmber(500);
                progreso = (TextView) findViewById(R.id.textProgress);
                for (int i = 0; i < 10; i++) {

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i >= 1){
                        progreso.setText("Paso " + i);
                    }
                    /*if (i == 2) {
                        mUiHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "I am at the middle of background task", Toast.LENGTH_LONG).show();
                                //PrimeNUmber(500);
                                //Toast.makeText(MainActivity.this, "I am at the middle of background task" + PrimeNUmber(500), Toast.LENGTH_LONG).show();
                            }
                        });
                    }*/
                }
                mUiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,
                                "Tarea completada!",
                                Toast.LENGTH_LONG)
                                .show();
                        text = (TextView) findViewById(R.id.textView1);
                        text.setText(number.toString());
                    }
                });
            }
        };
        mWorkerThread.start();
        mWorkerThread.prepareHandler();
        mWorkerThread.postTask(task);
        mWorkerThread.postTask(task);
    }

    protected BigInteger PrimeNUmber(int number) {
        int n = number;
        //int myProgress = 0;
        BigInteger prime = new BigInteger("2");
        for(int i=0;i<n;i++){
            //publishProgress(myProgress+=10);
            prime=prime.nextProbablePrime();
        }
        return prime;
    }

    @Override
    protected void onDestroy() {
        mWorkerThread.quit();
        super.onDestroy();
    }

}
