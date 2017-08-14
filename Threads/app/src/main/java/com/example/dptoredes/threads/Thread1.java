package com.example.dptoredes.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class Thread1 extends AsyncTask<Integer, Integer, BigInteger> {
    TextView textoresultado;
    ProgressBar progressBar;

    public Thread1(TextView textoresultado){
        this.textoresultado = textoresultado;
    }

    @Override
    protected BigInteger doInBackground(Integer... params) {
        int n = params[0];
        BigInteger prime = new BigInteger("2");
        for(int i=0;i<n;i++){
            prime=prime.nextProbablePrime();
        }
        return prime;
    }

    protected void onProgressUpdate(Integer... values) {
        // Executes whenever publishProgress is called from doInBackground
        // Used to update the progress indicator
        //progressBar.setProgress(values[0]);
        //textoresultado.setText(values[0].toString());
    }


    protected void onPostExecute(BigInteger result) {
        //progressBar.setVisibility(View.INVISIBLE);
        textoresultado.setText(result.toString());
    }


}
