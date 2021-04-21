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

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

//需要繼承 AppCompatActivity 才能使用。 需要傳入 context,activity
public class Permission_Function extends AppCompatActivity {
    private final String TAG = "權限";
    private List<String> unRequest = new ArrayList<>();

    public boolean CheckPermission(Context context,Activity activity, String[] permissionList){
        for( String permission : permissionList){

            switch (permission) {

                case "ACCESS_FINE_LOCATION":
                    if ( ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {       // GPS
                        unRequest.add(Manifest.permission.ACCESS_FINE_LOCATION);
                    }
                    break;

                case "READ_PHONE_STATE":
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {          // 手機資訊
                        unRequest.add(Manifest.permission.READ_PHONE_STATE);
                    }
                    break;

                case "WRITE_EXTERNAL_STORAGE":
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){    // SD Write
                        unRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    }
                    break;

                case "READ_EXTERNAL_STORAGE":
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {     // SD Read
                        unRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE);
                    }
                    break;

                case "CAMERA":
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){                    // Camera
                        unRequest.add(Manifest.permission.CAMERA);
                    }
                    break;

                case "ACCESS_COARSE_LOCATION":
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {                   // Camera
                        unRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION);
                    }
                    break;

                case "BODY_SENSORS":
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.BODY_SENSORS) != PackageManager.PERMISSION_GRANTED){            // Sensor
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                            unRequest.add(Manifest.permission.BODY_SENSORS);
                        } else {Log.e(TAG, "檢查權限 API版本不足");}
                    }
                    break;
            }
        }
        if(!unRequest.isEmpty()){
            ActivityCompat.requestPermissions(activity,unRequest.toArray(new String[0]),1);
            return false;
        }else
            return true;
    }

    public boolean RequestPermission(Activity activity, List<String> unRequestPermission){
        ActivityCompat.requestPermissions(activity, unRequestPermission.toArray(new String[0]), 1);
        //檢查權限是否全部允許
        for(String i : unRequestPermission){
            if(ActivityCompat.shouldShowRequestPermissionRationale(activity,i)){
                ActivityCompat.requestPermissions(activity, new String[]{i}, 1);
            }
        }
        return true;
    }
}
