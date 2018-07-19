package com.soo.handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvCount = null;
    private static final String TAG = "SOO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = (TextView) findViewById(R.id.tv_count);
        Log.i(TAG, "onCreate: after findViewById()..");
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_start :
                Log.i(TAG, "onClick: btn_start");
                tvCount.setText("Counting Start~~\n");
                countFunc();
                break;
            case R.id.btn_stop :
                Log.i(TAG, "onClick: btn_stop");
                tvCount.setText("Counting Stopped!!\n");
                break;
            default:
                break;
        }

    }

    void countFunc() {
        Log.i(TAG, "countFunc: start..");
        for(int i=1; i<=100; i++) {
            tvCount.append("count index : " + i + "\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart: ");
        super.onRestart();
    }
}
