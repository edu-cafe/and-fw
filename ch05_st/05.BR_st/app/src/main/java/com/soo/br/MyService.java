package com.soo.br;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    MyThread mythread;
    boolean runFlag = true;
    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        Log.d("SOO", "MyService : onBind()..");
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        Log.d("SOO", "MyService : onCreate()..");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Log.d("SOO", "MyService : onStartCommand()..");
        runFlag = true;
        mythread = new MyThread();
        mythread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        runFlag = false;
        super.onDestroy();

        Log.d("SOO", "MyService : onDestroy()..");
    }

    class MyThread extends Thread {
        int cnt=0;

        @Override
        public void run() {
            while(runFlag) {
                cnt++;
                Log.i("SOO", "====>Thread doing_" + cnt);
                if(cnt==10) {
                    Intent intent = new Intent("____________");
                    ____________(intent);
//					runFlag = false;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
