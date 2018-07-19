package com.soo.bundleparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText myName;
    private EditText myAge;
    private EditText myBirthday;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myName = (EditText) findViewById(R.id.myName);
        myAge = (EditText) findViewById(R.id.myAge);
        myBirthday = (EditText) findViewById(R.id.myBirthday);

        submitButton = (Button) findViewById(R.id.ok);
        submitButton.setOnClickListener(new View.OnClickListener() {

            private String inputMyName;
            private int inputMyAge;
            private String inputMyBirthday;

            Student student = null;

            @Override
            public void onClick(View v) {
                inputMyName =myName.getText().toString();
                inputMyAge =Integer.valueOf(myAge.getText().toString());
                inputMyBirthday =myBirthday.getText().toString();

                Log.d("SOO", "onClick() ==> name:" + inputMyName + ", age:" + inputMyAge + ", birthday:" + inputMyBirthday);

                student = new ______(inputMyName, inputMyAge, inputMyBirthday);

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("ID", 11);
                intent._________("STUDENT", ______ );
                startActivity(intent);
            }
        });


    }

}
