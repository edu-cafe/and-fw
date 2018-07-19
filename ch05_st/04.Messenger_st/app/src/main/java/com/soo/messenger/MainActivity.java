package com.soo.messenger;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int MSG_SAY_HELLO = 1;
    Intent service;

    /**
     * Handler of incoming messages from service.
     */
    protected class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Log.i("SOO","-----------> MessengerTest: IncomingHandler(rx MSG_SAY_HELLO)...");
                    handleSayHello(msg.arg1);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
    final Messenger mMessenger = new _______________ ;

    private void handleSayHello(int cnt)
    {
        Toast.makeText(getApplicationContext(), "hello_"+cnt+"!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button)findViewById(R.id.stopButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("SOO","MessengerTest: Start Button Clicked");

                service = new Intent(v.getContext(), MyService.class);
                service.putExtra("MyMessenger", __________);
                startService(service);

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("SOO","MessengerTest: Stop Button Clicked");
                stopService(service);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("SOO","MessengerTest: onStop() Called");
        // Stop the service
        stopService(service);
    }
}
