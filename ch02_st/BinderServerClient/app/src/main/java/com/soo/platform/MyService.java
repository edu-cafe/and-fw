package com.soo.platform;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }
    private MyServiceBinder myServiceBinder = new MyServiceBinder();

    public class MyServiceBinder extends Binder implements IMyService{
        private int status = 70;

        public int getStatus() {
            Log.i("SOO","-----------> MyService: getStatus()...");
            return status;
        }

    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.i("SOO","-----------> MyService: onBind()...");
        return __________;
    }

    @Override
    public void onCreate() {
        Log.i("SOO","-----------> MyService: onCreate()...");
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("SOO","-----------> MyService: onUnbind()...");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("SOO","-----------> MyService: onDestroy()...");
        super.onDestroy();
    }
}
