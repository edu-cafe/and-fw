package com.soo.bundleparcelable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private Bundle bundle;
    private TextView resultMyName;
    private TextView resultMyAge;
    private TextView resultMyBirthday;
    private Button backBtn;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        Log.d("SOO", "SubActivity Start!!");

        resultMyName = (TextView) findViewById(R.id.resultMyName);
        resultMyAge = (TextView) findViewById(R.id.resultMyAge);
        resultMyBirthday = (TextView) findViewById(R.id.resultMyBirthday);

        bundle = this.getIntent()._________();
        Log.d("SOO", "After SubActivity getExtras()!!");

        int id = bundle.getInt("ID");
        Student student = bundle.________("STUDENT");

        Log.d("SOO", "SubActivity() ==> id : " + id + ", name:" + student.getName() + ", "
                + "age:" + student.getAge() + ", birthday:" + student.getBirtday());

        resultMyName.setText(student.getName());
        resultMyAge.setText(String.valueOf(student.getAge()));
        resultMyBirthday.setText(student.getBirtday());

        backBtn = (Button) findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
