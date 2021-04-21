package com.example.recycleview_v0.Object;

/**
 * 專案名稱:recycleview_v0
 * 類描述:
 * 建立人:user01
 * 建立時間:2020/9/11 上午 10:24
 * 修改人:user01
 * 修改時間:2020/9/11 上午 10:24
 * 修改備註:
 */
public class Order {
    private String orderTime;
    private String deliveryTime;
    private String vegetableName; //蔬菜名稱
    private String vegetableID; //蔬菜ID
    private String number; //數量
    private String price; //價格
    private String customerName; // 顧客對象
    private String customerPhoneNumber; // 顧客電話
    private String remark;  //備註

    public Order(){    }

    public Order(String orderTime, String deliveryTime, String vegetableName, String vegetableID, String number,
                 String price, String customerName, String customerPhoneNumber, String remark){
        this.orderTime = orderTime;
        this.deliveryTime = deliveryTime;
        this.vegetableName = vegetableName;
        this.vegetableID = vegetableID;
        this.number = number;
        this.price = price;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.remark = remark;
    }
    public String getorderTime(){return orderTime;}
    public String getdeliveryTime(){return deliveryTime;}
    public String getvegetableName(){return vegetableName;}
    public String getvegetableID(){return vegetableID;}
    public String getnumber(){return number;}
    public String getprice(){return price;}
    public String getcustomerName(){return customerName;}
    public String getcustomerPhoneNumber(){return customerPhoneNumber;}
    public String getremark(){return remark;}

    public void setorderTime(String orderTime){this.orderTime = orderTime;}
    public void setdeliveryTime(String deliveryTime){this.deliveryTime = deliveryTime;}
    public void setvegetableName(String vegetableName){ this.vegetableName = vegetableName;}
    public void setvegetableID(String vegetableID){ this.vegetableID = vegetableID;}
    public void setnumber(String number){ this.number = number;}
    public void setprice(String price){ this.price = price;}
    public void setcustomerName(String customerName){ this.customerName = customerName;}
    public void setcustomerPhoneNumber(String customerPhoneNumber){ this.customerPhoneNumber = customerPhoneNumber;}
    public void setremark(String remark){ this.remark = remark;}
}
