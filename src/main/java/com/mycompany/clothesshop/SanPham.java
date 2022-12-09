/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clothesshop;

/**
 *
 * @author Admin
 */
public class SanPham {
    public int id;
    private String name;
    private String madeBy;
    private double price;
    private String description;
    private int quantity;
    
    
    public SanPham(int idInput, String nameInput, String madeByInput, double priceInput, String desriptionInput, int quantityInput){
        this.id = idInput;
        this.name = nameInput;
        this.madeBy = madeByInput;
        this.price = priceInput;
        this.description = desriptionInput;
        this.quantity = quantityInput;
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
    public String getMadeBy(){
        return madeBy;
    }
    
    
    public void setId(int id){
       this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void getPrice(double price){
        this.price = price;
    }
    public void getDescription(String description){
        this.description = description;
    }
    public void setMadeBy(String madeBy){
        this.madeBy = madeBy;
    }
    public SanPham(){}
    
}
