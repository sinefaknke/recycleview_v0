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

public class FTP_Object {
    private String FTP_ADDRESS = "";
    private short FTP_PORT = 0;
    private String FTP_hostname = "";
    private String FTP_password = "";

    public FTP_Object(String FTP_ADDRESS, short FTP_PORT, String FTP_hostname, String FTP_password){
        this.FTP_ADDRESS = FTP_ADDRESS;
        this.FTP_PORT = FTP_PORT;
        this.FTP_hostname = FTP_hostname;
        this.FTP_password = FTP_password;
    }

    public String getFTP_ADDRESS(){ return FTP_ADDRESS;}

    public short getFTP_PORT(){ return FTP_PORT;}

    public String getFTP_hostname(){ return FTP_hostname;}

    public String getFTP_password(){ return FTP_password;}

    public void setFTP_ADDRESS(String FTP_ADDRESS){ this.FTP_ADDRESS = FTP_ADDRESS; }

    public void setFTP_PORT(short FTP_PORT){ this.FTP_PORT = FTP_PORT; }

    public void setFTP_hostname(String FTP_hostname){ this.FTP_hostname = FTP_hostname; }

    public void setFTP_password(String FTP_password){ this.FTP_password = FTP_password; }
}
