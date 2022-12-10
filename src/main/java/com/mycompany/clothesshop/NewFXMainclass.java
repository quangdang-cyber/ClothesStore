package com.mycompany.clothesshop;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

/**
 *
 * @author MY PC
 */
public class NewFXMainclass  {
    @FXML
    private Button btnThanhToan;
    
    @FXML
    void thanhToan(ActionEvent event)throws IOException{
        App.setRoot("FirstPay");
    }
    @FXML
    void khuyenMai(ActionEvent event)throws IOException{
        App.setRoot("KhuyenMai");
    }
    
    @FXML
    void quanLiSanPham(ActionEvent event)throws IOException{
        App.setRoot("QuanLySP");
    }
    @FXML
    void thongKe(ActionEvent event)throws IOException{
        App.setRoot("ThongKe");
    }
    
}
