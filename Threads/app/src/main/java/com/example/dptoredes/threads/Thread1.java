package com.example.dptoredes.threads;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.math.BigInteger;

/**
 * Created by Majito on 14/08/2017.
 */

public class Thread1 extends AsyncTask<Integer, Integer, BigInteger> {
    TextView textoresultado, Progreso;
    ProgressBar progress;


    public Thread1(TextView textoresultado, ProgressBar progressBar, TextView textProgress){
        this.textoresultado = textoresultado;
        this.progress = progressBar;
        this.Progreso = textProgress;
    }

    @Override
    protected BigInteger doInBackground(Integer... params) {
        int n = params[0];
        int myProgress = 0;
        BigInteger prime = new BigInteger("2");
        for(int i=0;i<n;i++){
            publishProgress(myProgress+=10);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prime=prime.nextProbablePrime();
        }
        return prime;
    }

    protected void onProgressUpdate(Integer... values) {
        // Executes whenever publishProgress is called from doInBackground
        // Used to update the progress indicator
        super.onProgressUpdate(values);
        if (values[0] == 100){
            Progreso.setText("Listo!");
        } else {
            Progreso.setText("Paso "+ values[0]/10);
        }
        progress.setProgress(values[0]);
    }

    protected void onPostExecute(BigInteger result) {
        textoresultado.setText(result.toString());
    }


}