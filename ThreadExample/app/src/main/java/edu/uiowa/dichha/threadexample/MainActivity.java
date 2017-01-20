package edu.uiowa.dichha.threadexample;

import android.icu.text.SimpleDateFormat;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Message;

import java.util.Date;


public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String value = bundle.getString("myKey");

            TextView dianesText = (TextView) findViewById(R.id.dianesText);
            dianesText.setText(value);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View view){

        Runnable runnable = new Runnable() {
            long endTime = System.currentTimeMillis()+1000*20;

            @Override
            public void run() {
                Message msg = handler.obtainMessage();
                Bundle bundle = new Bundle();
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
                String dateString = dateFormat.format(new Date());
                bundle.putString("myKey", dateString);
                msg.setData(bundle);
                handler.sendMessage(msg);

            }


        };
        Thread thread = new Thread(runnable);
        thread.start();


    }
}
