/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clothesshop;

/**
 *
 * @author Admin
 */
public class User {
    private String name;
    private String password;
    public User(String nameInput, String passwordInput){
        this.name = nameInput;
        this.password = passwordInput;
    }
    
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public User(){}
    
}
