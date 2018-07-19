package com.soo.asynctask;

import android.os.AsyncTask;
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
    TextView tvCount = null;
    private CountTask mCountTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = (TextView) findViewById(R.id.tv_count);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_thread_start:
                mCountTask = new CountTask();
                mCountTask.execute(200);
                break;
            case R.id.btn_thread_stop_msg:
                mCountTask.cancel(true);
                break;
            default:
                break;
        }

    }

    class CountTask extends .............  {
        private boolean isPlay = false;

        @Override
        protected void .......... {
            super.onPreExecute();
            tvCount.setText("CountTask Start..\n");
        }

        @Override
        protected Integer .......... {
            int i = 0;
            while (i<params[0].intValue() && (isCancelled() == false)) {
                i++;
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return i;
        }

        @Override
        protected void ............ {
            super.onProgressUpdate(values);
            tvCount.setText("index : " + values[0].intValue() + "\n" + "Current Time : " + getNowDateTime() + "\n");
        }

        @Override
        protected void ........ {
            super.onPostExecute(integer);
            tvCount.setText("CountTask Done..\n");
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            tvCount.setText("CountTask Cancelled\n");

        }
    }

    public String getNowDateTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return new SimpleDateFormat("HHmmss").format(date);
    }
}




