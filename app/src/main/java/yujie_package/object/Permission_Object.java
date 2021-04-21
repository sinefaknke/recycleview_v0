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

public class Permission_Object {

    private boolean ACCESS_FINE_LOCATION = false;
    private boolean BODY_SENSORS = false;
    private boolean READ_PHONE_STATE = false;
    private boolean WRITE_EXTERNAL_STORAGE = false;
    private boolean READ_EXTERNAL_STORAGE = false;
    private boolean CAMERA = false;
    private boolean ACCESS_COARSE_LOCATION = false;

    public Permission_Object(boolean ACCESS_FINE_LOCATION, boolean BODY_SENSORS, boolean READ_PHONE_STATE,
                             boolean WRITE_EXTERNAL_STORAGE, boolean READ_EXTERNAL_STORAGE, boolean CAMERA,
                             boolean ACCESS_COARSE_LOCATION){
        this.ACCESS_FINE_LOCATION = ACCESS_FINE_LOCATION;
        this.BODY_SENSORS = BODY_SENSORS;
        this.READ_PHONE_STATE = READ_PHONE_STATE;
        this.WRITE_EXTERNAL_STORAGE = WRITE_EXTERNAL_STORAGE;
        this.READ_EXTERNAL_STORAGE = READ_EXTERNAL_STORAGE;
        this.CAMERA = CAMERA;
        this.ACCESS_COARSE_LOCATION = ACCESS_COARSE_LOCATION;

    }

    /**     get     */
    public synchronized boolean getACCESS_FINE_LOCATION(){ return ACCESS_FINE_LOCATION; }

    public synchronized boolean getBODY_SENSORS(){ return BODY_SENSORS; }

    public synchronized boolean getREAD_PHONE_STATE(){ return READ_PHONE_STATE; }

    public synchronized boolean getWRITE_EXTERNAL_STORAGE(){ return WRITE_EXTERNAL_STORAGE; }

    public synchronized boolean getREAD_EXTERNAL_STORAGE(){ return READ_EXTERNAL_STORAGE; }

    public synchronized boolean getCAMERA(){ return CAMERA; }

    public synchronized boolean getACCESS_COARSE_LOCATION(){ return ACCESS_COARSE_LOCATION; }

    /**     set     */
    public synchronized void setACCESS_FINE_LOCATION(boolean ACCESS_FINE_LOCATION){ this.ACCESS_FINE_LOCATION = ACCESS_FINE_LOCATION; }

    public synchronized void setBODY_SENSORS(boolean BODY_SENSORS){ this.BODY_SENSORS = BODY_SENSORS; }

    public synchronized void setREAD_PHONE_STATE(boolean READ_PHONE_STATE){ this.READ_PHONE_STATE = READ_PHONE_STATE; }

    public synchronized void setWRITE_EXTERNAL_STORAGE(boolean WRITE_EXTERNAL_STORAGE){ this.WRITE_EXTERNAL_STORAGE = WRITE_EXTERNAL_STORAGE; }

    public synchronized void setREAD_EXTERNAL_STORAGE(boolean READ_EXTERNAL_STORAGE){ this.READ_EXTERNAL_STORAGE = READ_EXTERNAL_STORAGE; }

    public synchronized void setCAMERA(boolean CAMERA){ this.CAMERA = CAMERA; }

    public synchronized void setACCESS_COARSE_LOCATION(boolean ACCESS_COARSE_LOCATION){ this.ACCESS_COARSE_LOCATION = ACCESS_COARSE_LOCATION; }

}
