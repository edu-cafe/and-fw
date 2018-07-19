package com.soo.platform;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceClient extends AppCompatActivity {

    /** Called when the activity is first created. */
    public ServiceConnection conn=null;
    private int statusValue = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button)findViewById(R.id.stopButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("SOO","ServiceClient: Start Button Clicked");

                ..........
                ________(____,______, Context.BIND_AUTO_CREATE);

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.i("SOO","ServiceClient: Stop Button Clicked");
                ______________
            }
        });

        conn=new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder service){
                Log.i("SOO", "ServiceClient: Service Connected!!");
                ________ myService = (_______) service;
                statusValue = myService.getStatus();
                Log.i("SOO", "ServiceClient: Service Bind     "+statusValue);
                Log.i("SOO", "ServiceClient: ComponentName   "+name);
            }
            public void onServiceDisconnected(ComponentName name){
                Log.i("SOO", "onServiceDisconnected()..");
            }
        };
    }
}
