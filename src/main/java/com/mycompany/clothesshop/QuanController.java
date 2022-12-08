/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.clothesshop;

import org.apache.commons.codec.digest.DigestUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.*;
import java.lang.ClassNotFoundException;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class QuanController{
    public TableView treeview;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colQuantity;
    public TableColumn colDescription;
    public TableColumn colRemain;
    
    @FXML
    private TextField btsearch;
    
    @FXML 
    private MenuBar menu;
    
    @FXML
    private TableView<?> tbSP;
    
    @FXML
    void Mainform (ActionEvent event) throws IOException{
        App.setRoot("formFXML");
    }
 
    @FXML
    public void Action (ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    void Quanly(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
       
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanly","root","Bichtram1812");
        Statement stm = conn.createStatement();
        
        
    }
        
}

