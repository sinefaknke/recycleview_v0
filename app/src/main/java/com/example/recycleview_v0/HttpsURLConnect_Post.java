package com.example.recycleview_v0;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

/**
 * 專案名稱:recycleview_v0
 * 類描述:
 * 建立人:user01
 * 建立時間:2020/9/22 下午 04:42
 * 修改人:user01
 * 修改時間:2020/9/22 下午 04:42
 * 修改備註:
 */
public class HttpsURLConnect_Post extends AsyncTask<String, Integer , String> {
    //AsyncTask<Params參數, Progress進度條, Result結果回傳值>
    private static final String TAG = "***HttpsURLConnect_Post";
    private InputStream inputStream;        //get socket inputStream
    private InputStreamReader inputStreamReader;
    private OutputStream outputStream;      //get socket outputStream
    private DataOutputStream dataOutputStream;
    private PrintWriter printWriter;        //write data by socket
    private BufferedReader bufferedReader;  //handel socket inputStream
    private HttpsURLConnection connection;
    private int connectStatus;
    public HttpsURLConnect_Post() {
        super();
    }

    @Override
    protected void onPreExecute() {
        //執行前，一些基本設定可以在這邊做
        super.onPreExecute();
        Log.d(TAG, "onPreExecute");
    }

    @Override
    protected String doInBackground(String... params) {//params:例如傳入的url
        //執行中，在背景做任務。
        Log.d(TAG, "doInBackground");
        String result = "";
        try {
            URL url = new URL(params[0]);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            outputStream = connection.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(params[1]+"=").append(URLEncoder.encode(params[2], "UTF-8")).append("&");//帶入傳入值"Year"和"2020"
            stringBuilder.append(params[3]+"=").append(URLEncoder.encode(params[4], "UTF-8")).append("&");//帶入傳入值"DepName"和"市場"
            dataOutputStream.writeBytes(stringBuilder.toString());
            dataOutputStream.flush();
            dataOutputStream.close();

            connectStatus = connection.getResponseCode();
            Log.d(TAG, "HttpCode: "+connectStatus);

            inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            if (inputStream != null) {
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += (line + "\n");
                }
            } else {
                result = "Did not work!";
            }
            Log.d(TAG, result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //執行中 可以在這邊告知使用者進度
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        //執行後 完成背景任務
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute");

    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
        Log.d(TAG, "onCancelled");
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(TAG, "onCancelled");
    }
}