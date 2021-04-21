package com.example.recycleview_v0;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 專案名稱:recycleview_v0
 * 類描述:
 * 建立人:user01
 * 建立時間:2020/9/22 下午 01:02
 * 修改人:user01
 * 修改時間:2020/9/22 下午 01:02
 * 修改備註:
 */

public class HttpURLConnect_Get extends AsyncTask<String, Integer , String> {
    //AsyncTask<Params參數, Progress進度條, Result結果回傳值>
    private static final String TAG = "***HttpURLConnect_Get";
    private InputStream inputStream;        //get socket inputStream
    private InputStreamReader inputStreamReader;
    private OutputStream outputStream;      //get socket outputStream
    private PrintWriter printWriter;        //write data by socket
    private BufferedReader bufferedReader;  //handel socket inputStream
    private HttpURLConnection connection;
    private int connectStatus;
    @Override
    protected void onPreExecute() {
        //執行前，一些基本設定可以在這邊做
        super.onPreExecute();
        Log.d(TAG,"onPreExecute");
    }

    @Override
    protected String doInBackground(String... params) {//params:例如傳入的url
        //執行中，在背景做任務。
        Log.d(TAG,"doInBackground");
        String result = "";
        try{
            URL url = new URL(params[0]);

            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            //connection.setRequestProperty("authentication", MainActivity.Authentication);
            connection.setDoInput(true);

            connectStatus = connection.getResponseCode();
            Log.d(TAG, String.valueOf(connectStatus));

            inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            Log.d(TAG, "123");

            if(inputStream != null){
                String line="";
                while ((line = bufferedReader.readLine()) != null) {
                    result += (line+"\n");
                }
            } else{
                result = "Did not work!";
            }
            Log.d(TAG,result);
            return  result;

        }catch (Exception e){
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
        Log.d(TAG,"onPostExecute");

    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
        Log.d(TAG,"onCancelled");
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(TAG,"onCancelled");
    }

//    private String GET(String APIUrl) {
//        Log.d(TAG,"GET");
//        String result = "";
//        HttpURLConnection connection;
//        try {
//            URL url = new URL(APIUrl);
//            connection = (HttpURLConnection)url.openConnection();
//            connection.setRequestMethod("GET");
//            //connection.setRequestProperty("authentication", MainActivity.Authentication);
//            connection.setDoInput(true);
//
//            InputStream inputStream = connection.getInputStream();
//            int status = connection.getResponseCode();
//            Log.d(TAG, String.valueOf(status));
//            if(inputStream != null){
//                InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
//                BufferedReader in = new BufferedReader(reader);
//
//                String line="";
//                while ((line = in.readLine()) != null) {
//                    result += (line+"\n");
//                }
//            } else{
//                result = "Did not work!";
//            }
//            return  result;
//        } catch (Exception e) {
//            Log.d("ATask InputStream", e.getLocalizedMessage());
//            e.printStackTrace();
//            return result;
//        }
//    }
//

}
