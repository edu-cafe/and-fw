package com.soo.handlerthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mMainValue = 0;
    private TextView mMainText;
    private TextView mBackText;
    private EditText mNumEdit;
    private CalcThread mThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainText = (TextView) findViewById(R.id.mainvalue);
        mBackText = (TextView) findViewById(R.id.backvalue);
        mNumEdit = (EditText) findViewById(R.id.number);

        mThread = new CalcThread("CalcThread", .........);
        mThread.setDaemon(true);
        mThread.start();

    }

    Handler mHandler = new .......() {
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0 :
                    mBackText.setText("Squre Result : " + msg.arg1);
                    break;
                case 1 :
                    mBackText.setText("Root Result : " + ((Double)msg.obj).doubleValue());
                    break;
            }
        }
    };

    public void mOnClick(View v) {
        Message msg;
        switch(v.getId()) {
            case R.id.increase :
                mMainValue++;
                mMainText.setText("Main Value : " + mMainValue);
                break;
            case R.id.square :
                msg = new Message();
                msg.what = 0;
                msg.arg1 = Integer.parseInt(mNumEdit.getText().toString());
                ..............
                break;
            case R.id.root :
                msg = new Message();
                msg.what = 1;
                msg.arg1 = Integer.parseInt(mNumEdit.getText().toString());
                ..............
                break;
        }
    }
}

class CalcThread extends ......... {
    Handler mMainHandler;
    Handler mBackHandler;

    public CalcThread(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public CalcThread(String name, Handler handler) {
        super(name);
        mMainHandler = handler;

        mBackHandler = new ....... {
            @Override
            public void .........(Message msg) {
                Message retmsg = new Message();
                switch(msg.what) {
                    case 0 :
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        retmsg.what = 0;
                        retmsg.arg1 = msg.arg1 * msg.arg1;
                        break;
                    case 1 :
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        retmsg.what = 1;
                        retmsg.obj = Double.valueOf(Math.sqrt((double)msg.arg1));
                        break;

                }
                .............
            }
        };
    }
}
