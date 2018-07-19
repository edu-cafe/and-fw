package com.soo.pendingintent;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    private PendingIntent mMySender;
    TextView txtMsg;
    Button btnStopService;
    Intent intentService;
    ComponentName service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mMySender = PendingIntent.___________(MainActivity.this,
                0, new Intent(MainActivity.this, MyService.class), 0);
//        mMySender = PendingIntent._________(MainActivity.this,
//                0, new Intent(MainActivity.this, NextActivity.class), 0);

        txtMsg = (TextView)findViewById(R.id.txtMsg);

        intentService = new Intent(this, MyCtlService.class);
        intentService.putExtra("MyService", ________ );
        _________(intentService);
        txtMsg.setText("MyService started.");

        btnStopService = (Button)findViewById(R.id.btnStopService);
        btnStopService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    _________(intentService);
                    txtMsg.setText("After stop service : \n" + service.getClassName());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), 1).show();
                }
            }
        });

//        finish();
    }
}
