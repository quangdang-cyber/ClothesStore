package com.mycompany.clothesshop;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MY PC
 */
public class SecondPayController{
    
    @FXML
    private TextField Name;
     
    @FXML
    private Button BtnTv;
    @FXML
    private TextField Numberphone;
    
    public void Submit (ActionEvent event){
        String name = Name.getText();
        String phone = Numberphone.getText();
    }
    
    public void Name (ActionEvent event){
        String name = Name.getText();        
    }
    
    @FXML
    void Payform (ActionEvent event) throws IOException{
        App.setRoot("FirstPay");
    }
    
    @FXML
    public void Action (ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
