package com.soo.p.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	private IMyService.Stub serviceStub = new ___________ {
    	private int status=50;
        public int getStatus(){
               return status;
        }
    };
    
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
