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

public class Socket_Object {
    private String Socket_IP_ADDRESS = "";
    private short Socket_IP_PORT = 0;
    private String Socket_DNS_ADDRESS = "";
    private short Socket_DNS_PORT = 0;

    public Socket_Object(String Socket_IP_ADDRESS, short Socket_IP_PORT, String Socket_DNS_ADDRESS, short Socket_DNS_PORT){
        this.Socket_IP_ADDRESS = Socket_IP_ADDRESS;
        this.Socket_IP_PORT = Socket_IP_PORT;
        this.Socket_DNS_ADDRESS = Socket_DNS_ADDRESS;
        this.Socket_DNS_PORT = Socket_DNS_PORT;
    }

    public String getSocket_IP_ADDRESS(){ return Socket_IP_ADDRESS;}

    public short getSocket_IP_PORT(){ return Socket_IP_PORT;}

    public String getSocket_DNS_ADDRESS(){ return Socket_DNS_ADDRESS;}

    public short getSocket_DNS_PORT(){ return Socket_DNS_PORT;}

    public void setSocket_IP_ADDRESS(String Socket_IP_ADDRESS){ this.Socket_IP_ADDRESS = Socket_IP_ADDRESS; }

    public void setSocket_IP_PORT(short Socket_IP_PORT){ this.Socket_IP_PORT = Socket_IP_PORT; }

    public void setSocket_DNS_ADDRESS(String Socket_DNS_ADDRESS){ this.Socket_DNS_ADDRESS = Socket_DNS_ADDRESS; }

    public void setSocket_DNS_PORT(short Socket_DNS_PORT){ this.Socket_DNS_PORT = Socket_DNS_PORT; }
}
