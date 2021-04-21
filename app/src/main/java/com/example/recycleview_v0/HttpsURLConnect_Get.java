package com.example.recycleview_v0;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.transform.Result;

/**
 * 專案名稱:recycleview_v0
 * 類描述:
 * 建立人:user01
 * 建立時間:2020/9/22 下午 03:34
 * 修改人:user01
 * 修改時間:2020/9/22 下午 03:34
 * 修改備註:
 */
public class HttpsURLConnect_Get extends AsyncTask<String, Integer , String> {
    // Param: 在doInBackground的參數。呼叫execute()時的引數。吃初始參數使用。
    // Progress: 在onProgressUpdate的參數。呼叫setProgress()時的引數。更新進度使用。
    // Result: 在onPostExecute的參數。 doInBackground裡的回傳值。回傳結果使用。
    private static final String TAG = "***HttpsURLConnect_Get";
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private HttpsURLConnection connection;
    private int connectStatus;

    public HttpsURLConnect_Get() { super();}

    @Override
    protected void onPreExecute() {
        // 執行前，一些基本設定可以在這邊做
        // 這在UI執行緒裡執行
        // 在這顯示Loading
        super.onPreExecute();
        Log.d(TAG, "onPreExecute");
    }

    @Override
    protected String doInBackground(String... params) {//params:例如傳入的url
        // 執行中，在背景做任務。
        // 這在子執行緒裡執行
        // 在這處理複雜的邏輯和進度更新
        Log.d(TAG, "doInBackground");
        String result = "";
        try {
            URL url = new URL(params[0]);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            //檢查網路狀態碼
            connectStatus = connection.getResponseCode();
            Log.d(TAG, "HttpCode: "+connectStatus);
            //讀取inputStream data
            inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            if (inputStream != null) {
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += (line + "\n");
                }
            }
            Log.d(TAG, result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // 這在UI執行緒裡執行
        // 在這關閉Loading
        super.onPostExecute(result);
        Log.d(TAG, "onPostExecute");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        // 這在UI執行緒裡執行
        // 在這更新Loading進度
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        // 這在UI執行緒裡執行
        // 在這處理Cancel事件的後續
        super.onCancelled();
        Log.d(TAG, "onCancelled");
    }
}
