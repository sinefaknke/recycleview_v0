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
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.lang.reflect.Method;

public class Service_Function extends AppCompatActivity {

    public LocationManager locationManager;
    public SensorManager sensorManager;
    public TelephonyManager telephonyManager;
    public ConnectivityManager connectivityManager;

    public Location myLocation;
    public String BestProvider;

    public Sensor sensorGravity;
    public Sensor sensorOrientation;
    public int CSQ = 0;
    public String imei;


    public void RequestService(Context context) {
        /**
         * To call system services we have to use running activity.
         * That means we need executed onCreate method that inherited to the super.
         * So to identify that we have to use the current application context to call system service.
         */
        locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        sensorManager = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        telephonyManager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);

        sensorOrientation = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorGravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

    }

    public PhoneStateListener phoneStateListener = new PhoneStateListener() {
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            try {
                Method methodGetLteDbm = SignalStrength.class.getMethod("getLteDbm");
                String dBm = String.valueOf(methodGetLteDbm.invoke(signalStrength));
                if (Integer.parseInt(dBm) < 0)
                    CSQ = Math.abs(((-113 - (int) methodGetLteDbm.invoke(signalStrength)) / 2));
                else
                    CSQ = 99;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public Location LocationInit(Context context) {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);//設定最大精度
        criteria.setAltitudeRequired(false);//不要求海拔訊息
        criteria.setBearingRequired(false);//不要求位置訊息
        criteria.setCostAllowed(true);//是否允許付費
        criteria.setPowerRequirement(Criteria.POWER_LOW);//電量要求
        BestProvider = locationManager.getBestProvider(criteria, true); //獲取最佳定位方式

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        myLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER); //bestProvider
        return myLocation;
    }

}
