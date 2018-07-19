package com.soo.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void _________(Context context, Intent intent) {
        Log.i("SOO", "onReceive");
        if(_______.getAction().equals("_______________")){
            Log.i("SOO", "My Service Complete received!");

            Intent service = new Intent(context, MyService.class);
            context.stopService(service);

            Intent myIntent = new Intent(context, NextActivity.class);
            myIntent.addFlags(Intent._____________ );
            _________.startActivity(myIntent);

        }
    }
}
