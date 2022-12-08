package com.mycompany.clothesshop;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class KhuyenMaiController{
  
    @FXML
    private Button BtReset;
    
    @FXML
    public void Action (ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void Mainform (ActionEvent event) throws IOException{
        App.setRoot("formFXML");
    }
    
     @FXML
    void reset(ActionEvent event)throws IOException{
//        App.setRoot("KhuyenMai");
    }
    
}
