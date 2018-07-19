package com.soo.intentex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);

        // Test1 - 명시적 Intent 1
        setContentView(R.layout.next);
        Button bt = (Button)findViewById(R.id.NextButton);
        bt.setOnClickListener(this);

        // Test2 - 명시적 Intent 2
//	    Intent intent = getIntent();
//	    Log.d("Intent_Test", intent.getStringExtra("data1"));
//	    Log.d("Intent_Test", String.valueOf(intent.getIntExtra("data2", 0)));
//	    Toast toast = Toast.makeText(getBaseContext(), "IntentData : "
//	    		+ intent.getStringExtra("data1")+ "."
//	    		+ String.valueOf(intent.getIntExtra("data2", 0)), Toast.LENGTH_LONG);
//		toast.show();

    }

    @Override
    public void onClick(View v) {
        // Test1 - 명시적 Intent 1
//        finish();


    // Test2 - 명시적 Intent 2
//    Intent intent = getIntent();
//    intent.putExtra("retData", "ok!!");
//    setResult(RESULT_OK, intent);
//    finish();

    // Test3 - 암시적 Intent
		finish();


    }
}
