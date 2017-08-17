package com.example.dptoredes.handlerthread;

import android.os.Handler;
import android.os.HandlerThread;

/**
 * Created by dptoredes on 15/08/17.
 */

public class MyHandlerThread extends HandlerThread {

    private Handler mWorkerHandler;

    public MyHandlerThread(String name) {
        super(name);
    }

    public void postTask(Runnable task){
        mWorkerHandler.post(task);
    }

    public void prepareHandler(){
        mWorkerHandler = new Handler(getLooper());
    }


}
