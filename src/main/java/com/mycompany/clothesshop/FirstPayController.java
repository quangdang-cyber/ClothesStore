package com.mycompany.clothesshop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MY PC
 */
public class FirstPayController{

    @FXML
    private Button BtnThanhToan;

    @FXML
    private void tfMasp(ActionEvent event) {
    }

    @FXML
    private void btnTim(ActionEvent event) {
    }
    
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
    void ContinuePay (ActionEvent event) throws IOException{
        App.setRoot("SecondPay");
    }
 
}
