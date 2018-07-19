package com.soo.messenger;

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
    Messenger myMessenger = null;
    static final int MSG_SAY_HELLO = 1;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("SOO","-----------> MyService: onCreate()...");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SOO", "MyService : onStartCommand()..");
        runFlag = true;
        myMessenger = intent._______________("_________");
        mythread = new MyThread();
        mythread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("SOO","-----------> MyService: onUnbind()...");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("SOO","-----------> MyService: onDestroy()...");
        runFlag = false;
        super.onDestroy();
    }

    class MyThread extends Thread {
        int cnt=0;

        @Override
        public void run() {
            while(runFlag) {
                cnt++;
                Log.i("SOO", "====>Thread doing_" + cnt);
//				Toast.makeText(getApplicationContext(), "server_"+cnt+"!", Toast.LENGTH_SHORT).show();  //error
                sayHello(cnt);
                if(cnt==20) {
                    runFlag = false;
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void sayHello(int cnt) {
        // Create and send a message to the service, using a supported 'what' value
        Log.i("SOO", "MyService: sayHello()..");
        Message msg = Message.________(null, MSG_SAY_HELLO, 0, 0);
        msg.arg1 = cnt;
        try {
            ___________________(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
