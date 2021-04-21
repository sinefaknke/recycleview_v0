package com.example.recycleview_v0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "***MainActivity";
    private static final String url_https_get = "https://www.hms.gov.taipei/api/BigData/project";
    private static final String url_https_post = "https://webs.water.gov.taipei/wns/Wns_Service.asmx/UseDegree";
    private Thread connectThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
    }

    private void initialization() {
        Log.i("*","開始初始化...");
        //setPermission();
        //setService();
        setView();
        //checkIODevice();
        //checkFileDir();
        setThread();
        Log.i("*","結束初始化...");
    };

    private void setView(){
        Log.i("*","開始設定介面...");
        Button button_GO = findViewById(R.id.button);
        button_GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void setThread(){
        connectThread = new Thread(http_get,"網路連線-get");
        connectThread.start();
    }

    private Runnable http_get = new Runnable() {
        @Override
        public void run() {
            /**API有加密(https) - GET*/
            HttpsURLConnect_Get h1 = new HttpsURLConnect_Get();
            String result1 = h1.doInBackground(url_https_get);//可以丟入參數，例如url
            Log.i(TAG,result1);
            //h1.execute(url_https_get); //不需要接收回傳值的話，可以直接調用此方法

            /**API有加密(https) - POST*/
            HttpsURLConnect_Post h2 = new HttpsURLConnect_Post();
            String result2 = h2.doInBackground(url_https_post,"Year","2020","DepName","市場");//url,參數名稱1,參數1,,參數名稱2,參數2
            Log.i(TAG,result2);
            //h2.execute(url_https_post,"Year","2020","DepName","市場"); //不需要接收回傳值的話，可以直接調用此方法
        }
    };
}