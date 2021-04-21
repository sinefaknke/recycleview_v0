package com.example.recycleview_v0.Object;
public class Product {
    private String Product_ID;
    private String Product_Name;
    private String Product_Specification;
    private String Product_Price;
    private String Product_Quantity;

    public Product(String Product_ID,String Product_Name,String Product_Specification,String Product_Price,String Product_Quantity){
        this.Product_ID = Product_ID;
        this.Product_Name = Product_Name;
        this.Product_Specification = Product_Specification;
        this.Product_Price = Product_Price;
        this.Product_Quantity = Product_Quantity;
    }
    
    public String getProduct_ID(){ return Product_ID; }

    public String getProduct_Name(){ return Product_Name; }

    public String getProduct_Specification(){ return Product_Specification; }

    public String getProduct_Price(){ return Product_Price; }

    public String getProduct_Quantity(){ return Product_Quantity; }

    public void setProduct_ID(String Product_ID){ this.Product_ID = Product_ID; }

    public void setProduct_Name(String Product_Name){ this.Product_Name = Product_Name; }

    public void setProduct_Specification(String Product_Specification){ this.Product_Specification = Product_Specification; }

    public void setProduct_Price(String Product_Price){ this.Product_Price = Product_Price; }

    public void setProduct_Quantity(String Product_Quantity){ this.Product_Quantity = Product_Quantity; }

}

