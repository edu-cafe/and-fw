package com.soo.intentex;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button bt = (Button) findViewById(R.id.MainButton);
        bt.setOnClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        // Test1 - 명시적 Intent 1
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);

        // Test2 - 명시적 Intent 2
//		Intent intent = new Intent(this, NextActivity.class);
//		intent.putExtra("data1", "kim");
//		intent.putExtra("data2", 17);
//		startActivityForResult(intent, 0);

        // Test3 - 암시적 Intent
//		Intent intent = new Intent();
//		intent.setAction("com.soo.action.ACTION_TEST");
//		startActivity(intent);

        // Test4 - 전화 Call 이용  (use-permission)
//        Intent intent = new Intent(Intent.ACTION_CALL,
//                Uri.parse("tel:010-1111-2222"));
//        startActivity(intent);

//        // Test4 - 전화 Call 이용  (use-permission)
////        requestPermissions(new String[] {Manifest.permission.ACCESS_COARSE_LOCATION,
////                Manifest.permission.CALL_PHONE},0);
//        requestPermissions(new String[] {Manifest.permission.CALL_PHONE},0);

        // Test5 - 전화번호 가져오기
//		Intent intent = new Intent(Intent.ACTION_PICK,
//				Uri.parse("content://com.android.contacts/data/phones"));
//		startActivity(intent);

        // Test6 - 브라우저 이용
//		Intent intent = new Intent(Intent.ACTION_VIEW,
//				Uri.parse("http://www.google.com"));
//		startActivity(intent);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        // TODO Auto-generated method stub
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:010-1111-2222"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d("SOO", "------>onClick: CALL_PHONE denied!!");
            return;
        }
        Log.d("SOO", "------>onClick: CALL_PHONE ok!!");
        startActivity(intent);
    }

    // Test2 - 명시적 Intent 2
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    Toast toast = Toast.makeText(getBaseContext(), "onActivityResult : " + data.getStringExtra("retData"), Toast.LENGTH_LONG);
                    toast.show();
                    Log.d("Intent_Test", "----->" + data.getStringExtra("retData"));
                }
                break;
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.soo.intentex/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.soo.intentex/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
