package com.mycompany.clothesshop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ThongKeController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
}
