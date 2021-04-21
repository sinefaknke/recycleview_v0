package yujie_package.object;

/**
 * 專案名稱:demo_v0
 * 類描述:
 * 建立人:黃鈺傑
 * 建立時間:2020/9/4 下午 03:38
 * 修改人:黃鈺傑
 * 修改時間:2020/9/4 下午 03:38
 * 修改備註:
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Status_Object {

    private boolean Permission_check = false;
    private boolean Service_check = false;
    private boolean SDCard_exist = false;
    private boolean Camera_exist = false;
    private boolean SerialPort_exist = false;
    private String SimCard_status = "1";

    private boolean Socket_status = false;
    private boolean Server_response = false;
    private int CSQ_code = 99;
    private String Location = "N3725.3199, E-1225.04";

    public Status_Object(){

    }

    public Status_Object(boolean Permission_check, boolean Service_check, boolean SDCard_exist,
                         boolean SerialPort_exist, String SimCard_status, boolean Camera_exist,
                         boolean Socket_status, boolean Server_response, int CSQ_code, String Location){
        this.Permission_check = Permission_check;
        this.Service_check = Service_check;
        this.SDCard_exist = SDCard_exist;
        this.Camera_exist = Camera_exist;
        this.SerialPort_exist = SerialPort_exist;
        this.SimCard_status = SimCard_status;
        this.Socket_status = Socket_status;
        this.Server_response = Server_response;
        this.CSQ_code = CSQ_code;
        this.Location = Location;
    }

    /**     get     */
    public synchronized boolean getPermission_check(){ return Permission_check; }

    public synchronized boolean getService_check(){ return Service_check; }

    public synchronized boolean getSDCard_exist(){ return SDCard_exist; }

    public synchronized boolean getCamera_exist(){ return Camera_exist; }

    public synchronized boolean getSerialPort_exist(){ return SerialPort_exist; }

    public synchronized String getSimCard_status(){ return SimCard_status; }

    public synchronized boolean getSocket_status(){ return Socket_status; }

    public synchronized boolean getServer_response(){ return Server_response; }

    public synchronized int getCSQ_code(){ return CSQ_code; }

    public synchronized String getLocation(){ return Location; }

    public synchronized List<String> getAll_Status(){
        ArrayList<String> All_Status = new ArrayList<>();
        SimpleDateFormat currentTime = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
        currentTime.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        All_Status.add(currentTime.format(new Date()));
        All_Status.add("Permission_check: " + Permission_check);
        All_Status.add("Service_check: " + Service_check);
        All_Status.add("SDCard_exist: " + SDCard_exist);
        All_Status.add("Camera_exist: " + Camera_exist);
        All_Status.add("SerialPort_exist: " + SerialPort_exist);
        All_Status.add("SimCard_status:　" + SimCard_status);
        All_Status.add("Socket_status: " + Socket_status);
        All_Status.add("Server_response: " + Server_response);
        All_Status.add("CSQ_code: " + CSQ_code);
        All_Status.add("Location: " + Location);
        return All_Status; }

    /**     set     */
    public synchronized void setPermission_check(boolean Permission_check){ this.Permission_check = Permission_check; }

    public synchronized void setService_check(boolean Service_check){ this.Service_check = Service_check; }

    public synchronized void setSDCard_exist(boolean SDCard_exist){ this.SDCard_exist = SDCard_exist; }

    public synchronized void setCamera_exist(boolean Camera_exist){ this.Camera_exist = Camera_exist; }

    public synchronized void setSerialPort_exist(boolean SerialPort_exist){ this.SerialPort_exist = SerialPort_exist; }

    public synchronized void setSimCard_status(String SimCard_status){
        /**Returns a constant indicating the state of the default SIM card.*/
        switch (SimCard_status){
            case "0":
                this.SimCard_status = "UNKNOWN";break;
            case "1":
                this.SimCard_status = "ABSENT";break;
            case "2":
                this.SimCard_status = "PIN_REQUIRED";break;
            case "3":
                this.SimCard_status = "PUK_REQUIRED";break;
            case "4":
                this.SimCard_status = "NETWORK_LOCKED";break;
            case "5":
                this.SimCard_status = "READY";break;
            case "6":
                this.SimCard_status = "NOT_READY";break;
            case "7":
                this.SimCard_status = "PERM_DISABLED";break;
            case "8":
                this.SimCard_status = "CARD_IO_ERROR";break;
            case "9":
                this.SimCard_status = "CARD_RESTRICTED";break;
        }
    }

    public synchronized void setSocket_status(boolean Socket_status){ this.Socket_status = Socket_status; }

    public synchronized void setServer_response(boolean Server_response){ this.Server_response = Server_response; }

    public synchronized void setCSQ_code(int CSQ_code){ this.CSQ_code = CSQ_code; }

    public synchronized void setLocation(String Location){ this.Location = Location; }

}
