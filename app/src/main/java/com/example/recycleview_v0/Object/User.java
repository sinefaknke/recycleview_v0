package com.example.recycleview_v0.Object;
public class User {
    private String User_ID;
    private String User_Name;
    private String User_PhoneNumber;
    private String User_Remark;
    public User(String User_ID,String User_Name,String User_PhoneNumber,String User_Remark){
        this.User_ID = User_ID;
        this.User_Name = User_Name;
        this.User_PhoneNumber = User_PhoneNumber;
        this.User_Remark = User_Remark;
    }
    public String getUser_ID(){ return User_ID; }

    public String getUser_Name(){ return User_Name; }

    public String getUser_PhoneNumber(){ return User_PhoneNumber; }

    public String getUser_Remark(){ return User_Remark; }

    public void setUser_ID(String User_ID){ this.User_ID = User_ID; }

    public void setUser_Name(String User_Name){ this.User_Name = User_Name; }

    public void setUser_PhoneNumber(String User_PhoneNumber){ this.User_PhoneNumber = User_PhoneNumber; }

    public void setUser_Remark(String User_Remark){ this.User_Remark = User_Remark; }
}

