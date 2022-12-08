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

public class LoginController  {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String name = txtName.getText();
        String password = DigestUtils.md5Hex(txtPassword.getText());
        txtPassword.setText(password);
        
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanly","root","Bichtram1812");
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM user WHERE `name` = '" + name +"'"+ " AND `password` = '" + password+"'");
        while(rs.next()){
           txtName.setText("true");
           App.setRoot("formFXML");
        }
        
    }
    
    @FXML
    public void Action (ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

}
