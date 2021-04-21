package com.example.recycleview_v0;

import android.os.AsyncTask;
import android.util.Log;

/**
 * 專案名稱:recycleview_v0
 * 類描述:
 * 建立人:user01
 * 建立時間:2020/9/22 下午 12:56
 * 修改人:user01
 * 修改時間:2020/9/22 下午 12:56
 * 修改備註:
 */
public class HttpURLConnect_Post extends AsyncTask {
    private final static String TAG = "***HttpURLConnect_Post";
    @Override
    protected Object doInBackground(Object[] objects) {
        Log.d(TAG,"doInBackground");
        return null;
    }

    public HttpURLConnect_Post() {
        super();
        Log.d(TAG,"HttpURLConnect_Post");
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG,"onPreExecute");
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Log.d(TAG,"onPostExecute");

    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        Log.d(TAG,"onProgressUpdate");
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
        Log.d(TAG,"onCancelled");
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(TAG,"onCancelled");

    }
}
