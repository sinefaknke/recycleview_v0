package yujie_package.function;

/**
 * 專案名稱:demo_v0
 * 類描述:
 * 建立人:黃鈺傑
 * 建立時間:2020/9/4 下午 03:38
 * 修改人:黃鈺傑
 * 修改時間:2020/9/4 下午 03:38
 * 修改備註:
 */

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class Other_Functions extends AppCompatActivity {
    private String[] carDataArray = {"888888", "0040080", "073526", "A", "N2444.9763", "E12144.4289", "0.0", "0.0", "180917", "1023E", "G000000", "00171365", "", "", "", ":;:;:;:"};

    private boolean hasLastLatitude = false;
    private boolean hasLastLongitude = false;

    private String lastKnowLatitude = "";
    private String lastKnowLongitude = "";

    private Permission_Function _permissionFunction = new Permission_Function();

    /****************************************取得時間****************************************/
    public String getDate(String format, String timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return simpleDateFormat.format(new Date());
    }

    /****************************************取得緯度****************************************/
    public String getLongitude(Location myLocation) {
        if (myLocation == null) {
            if (hasLastLongitude)
                return lastKnowLongitude;
            return null;
        }
        hasLastLongitude = true;

        double longitude = myLocation.getLongitude();

        String stringLongitude = tudeToDM(longitude);
        if (longitude < 0) {
            lastKnowLongitude = "W" + stringLongitude;
        } else {
            lastKnowLongitude = "E" + stringLongitude;
        }

        carDataArray[3] = "A";
        return lastKnowLongitude;
    }

    /****************************************取得經度****************************************/
    public String getLatitude(Location myLocation) {
        if (myLocation == null) {
            if (hasLastLatitude)
                return lastKnowLatitude;
            return null;
        }
        hasLastLatitude = true;

        double latitude = myLocation.getLatitude();

        String stringLatitude = tudeToDM(latitude);
        if (latitude < 0) {
            lastKnowLatitude = "S" + stringLatitude;
        } else {
            lastKnowLatitude = "N" + stringLatitude;
        }
        return lastKnowLatitude;
    }

    /****************************************取得位子可用不可用****************************************/
    public String getPositionStatus(Location myLocation){
        if (myLocation == null) {
            return "V";
        }else{
            return "A";
        }
    }

    /****************************************轉換經緯度格式至度分****************************************/
    public String tudeToDM(double dd) {
        double lat = (int) dd;
        double min = Math.abs((dd - lat) * 60);
        return String.format("%.0f", lat) + String.format("%.4f", min);
    }

    /****************************************取得加速度****************************************/
    public String getSpeed(Location myLocation) {
        if (myLocation == null)
            return "0.0"; // null or 0.0

        return (new DecimalFormat("000.0").format(myLocation.getSpeed()));
    }

    /****************************************計算checkSum****************************************/
    public String getCheckSum(String[] myData) {
        String data = "";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            data = String.join(",", myData);
        } else {
            for (String curData : myData) {
                data += curData + ",";
            }
            data = data.substring(0, data.length() - 1);
        }

        int temp = 0;
        char[] mChar = data.toCharArray();
        for (int i = 0; i < mChar.length; i++) {
            if (i + 1 < mChar.length) {
                temp = ((int) (mChar[i]) ^ (int) (mChar[i + 1]));
                mChar[i + 1] = (char) temp;
            }
        }
        return data + "*" + (Integer.toHexString(temp)).toUpperCase();
    }

    /****************************************取得應用程式資料夾目錄****************************************/
    public File[] getExternalFilesDirs(Context context){
        /**
         * externalFilesDirs[0],Internal storage space
         * externalFilesDirs[1],External storage space         *
         * */
        File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, null);
        return externalFilesDirs;
    }

    /****************************************檢查檔案是否存在****************************************/
    public boolean checkFileExist(File FilesDirs){
        if(FilesDirs.exists()){
            return true;
        }else{
            return false;
        }
    }

    /****************************************將資料寫入SD卡****************************************/
    public void writeSDcardData(Context context, Activity activity, File failDataFileDirs, ArrayList<String> failData,boolean dataAppend){
        //check write Permission
        _permissionFunction.CheckPermission(context, activity, new String[]{"WRITE_EXTERNAL_STORAGE"});

        try {
            //FileWriter內的append屬性 false>>會覆蓋檔案
            FileWriter fileWriter = new FileWriter(failDataFileDirs, dataAppend);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while (!failData.isEmpty()) {
                Thread.sleep(100);
                bufferedWriter.write(failData.get(0) + "\r\n");
                bufferedWriter.flush();
                failData.remove(0);
            }
            fileWriter.close();
            bufferedWriter.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    /****************************************將資料讀出SD卡****************************************/
    public ArrayList<String> readSDcardData(Context context, Activity activity,File SDfailDataFileDirs){
        //check write Permission
        _permissionFunction.CheckPermission(context, activity, new String[]{"READ_EXTERNAL_STORAGE"});

        ArrayList<String> SDfailData = new ArrayList<>();
        try {
            if (!SDfailDataFileDirs.exists())
                return null;
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(SDfailDataFileDirs));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String currText = bufferedReader.readLine();
            while (currText != null) {
                Thread.sleep(100);
                SDfailData.add(currText);
                currText = bufferedReader.readLine();
            }
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return SDfailData;
    }

}
