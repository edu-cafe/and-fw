package com.soo.p.client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.soo.p.server.IMyService;
import com.soo.p.server.MyService;

public class AIDLClient extends Activity {
    /** Called when the activity is first created. */
	public ServiceConnection conn=null;
    private int statusValue = 0;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button)findViewById(R.id.stopButton);
        startButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Log.i("SOO","ServiceClient: Start Button Clicked");
	
            	Intent i = new Intent(........);      	
   				__________(i,conn, Context.BIND_AUTO_CREATE);
   				

   			}
        });
        
        stopButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.i("SOO","ServiceClient: Stop Button Clicked");
				unbindService(conn);
			}
		});
        
        conn=new ServiceConnection() {
        	public void onServiceConnected(ComponentName name, IBinder service){
        		Log.i("SOO", "ServiceClient: Remote Service Connected!!");     		
        		
        		IMyService myService = ________________(service);
        		try {
					statusValue = myService.getStatus();
	        		Log.i("SOO", "ServiceClient: Remote Service Bind     "+statusValue);
	        		Log.i("SOO", "ServiceClient: ComponentName   "+name);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	public void onServiceDisconnected(ComponentName name){
        		Log.i("SOO", "Service UnBind");
        	}
        };
    }
}