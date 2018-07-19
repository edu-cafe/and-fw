package com.soo.pendingintent;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyCtlService extends Service {
    ServiceThread thread = null;

    public MyCtlService() {
    }


    @Override
    public IBinder onBind(Intent arg0) {
        Log.d("SOO", "MyService : onBind()..");
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        Log.d("SOO", "MyCtlService : onCreate()..");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Log.d("SOO", "MyCtlService : onStartCommand()..");
        PendingIntent myservice = intent._____________("MyService");

        thread = new ServiceThread(________);
        thread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("SOO", "MyCtlService : onDestroy()..");
        thread.stopThread();
    }
}

class ServiceThread extends Thread implements Runnable {
    private boolean isPlay = false;
    PendingIntent myservice;

    public ServiceThread(PendingIntent intent) {
        isPlay = true;
        myservice = intent;
    }
    public void isThreadState(boolean isPlay) {
        this.isPlay = isPlay;
    }

    public void stopThread() {
        isPlay = false;
        myservice = null;
    }

    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            if(myservice != null) myservice.______();
        } catch (PendingIntent.CanceledException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
