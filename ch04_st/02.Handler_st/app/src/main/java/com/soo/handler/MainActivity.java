package com.soo.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int SEND_THREAD_INFOMATION = 1;
    private static final int SEND_THREAD_STOP_MESSAGE = 2;
    private TextView tvCount = null;
    private SendMessageHandler mMainHandler = null;
    private CountThread mCountThread = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = (TextView) findViewById(R.id.tv_count);
        .............
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_thread_start :
                .......
				
                break;
            case R.id.btn_thread_stop_msg :
                ..........(SEND_THREAD_STOP_MESSAGE);
                break;
            default:
                break;
        }

    }

    class SendMessageHandler extends ...... {
		
		...............
		
	}	

    class CountThread ........... {
        private boolean isPlay = false;

        public CountThread() {
            isPlay = true;
        }

        public void isThreadState(boolean isPlay) {
            this.isPlay = isPlay;
        }

        public void stopThread() {
            isPlay = false;
        }

        @Override
        public void run() {
            super.run();
            int i = 0;
            while(isPlay) {
                i++;
                Message msg = .........;         // get Message
                msg.____ = SEND_THREAD_INFOMATION;                  // set Message ID
                msg.____ = i;                                       // set Message Info
                msg.____ = Integer.valueOf(getNowDateTime());
                String hi = new String("Count Thread Doing...");    // set Message Info
                msg.____ = hi;
                ..............
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public String getNowDateTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return new SimpleDateFormat("HHmmss").format(date);
    }
}
