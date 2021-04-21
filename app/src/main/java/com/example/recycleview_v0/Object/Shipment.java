package com.example.recycleview_v0.Object;
public class Shipment {
    private String Shipment_ID;
    private String Order_ID;
    private String Delivery_Time;
    private String User_ID;
    private String Recorder_ID;
    private String Shipped_Product_ID;
    private String Unshipped_Product_ID;

    public Shipment(String Shipment_ID, String Order_ID, String Delivery_Time, String User_ID, String Recorder_ID, String Shipped_Product_ID, String Unshipped_Product_ID) {
        this.Shipment_ID = Shipment_ID;
        this.Order_ID = Order_ID;
        this.Delivery_Time = Delivery_Time;
        this.User_ID = User_ID;
        this.Recorder_ID = Recorder_ID;
        this.Shipped_Product_ID = Shipped_Product_ID;
        this.Unshipped_Product_ID = Unshipped_Product_ID;
    }

    public String getShipment_ID() {
        return Shipment_ID;
    }

    public String getOrder_ID() {
        return Order_ID;
    }

    public String getDelivery_Time() {
        return Delivery_Time;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public String getRecorder_ID() {
        return Recorder_ID;
    }

    public String getShipped_Product_ID() {
        return Shipped_Product_ID;
    }

    public String getUnshipped_Product_ID() {
        return Unshipped_Product_ID;
    }

    public void setShipment_ID(String Shipment_ID) {
        this.Shipment_ID = Shipment_ID;
    }

    public void setOrder_ID(String Order_ID) {
        this.Order_ID = Order_ID;
    }

    public void setDelivery_Time(String Delivery_Time) {
        this.Delivery_Time = Delivery_Time;
    }

    public void setUser_ID(String User_ID) {
        this.User_ID = User_ID;
    }

    public void setRecorder_ID(String Recorder_ID) {
        this.Recorder_ID = Recorder_ID;
    }

    public void setShipped_Product_ID(String Shipped_Product_ID) {
        this.Shipped_Product_ID = Shipped_Product_ID;
    }

    public void setUnshipped_Product_ID(String Unshipped_Product_ID) {
        this.Unshipped_Product_ID = Unshipped_Product_ID;
    }
}

