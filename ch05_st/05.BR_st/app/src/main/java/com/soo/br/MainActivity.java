package com.soo.br;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    TextView txtMsg;
    Button btnStopService;
    Intent intentService;
    ComponentName service;
    MyReceiver myReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = (TextView)findViewById(R.id.txtMsg);

        intentService = new Intent(this, MyService.class);
        service = startService(intentService);
        txtMsg.setText("MyService started.");

        btnStopService = (Button)findViewById(R.id.btnStopService);
        btnStopService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    stopService(intentService);
                    txtMsg.setText("After stop service : \n" + service.getClassName());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), 1).show();
                }
            }
        });


        myReceiver = ......
        IntentFilter filter = new _________("com.soo.ACTION_COMPLETE");

        // register the receiver
        ...............

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}
