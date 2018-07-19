package com.soo.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.button);
        Button stopBtn = (Button) findViewById(R.id.button2);

        startBtn.setOnClickListener(this);
        ................
    }

    @Override
    public void onClick(View v) {
        switch(.......) {
            case R.id.button :
                ............
				............
                break;
            case R.id.button2 :
                ............
                break;
        }
    }
}
