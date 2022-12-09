package com.mycompany.clothesshop;
import org.apache.commons.codec.digest.DigestUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.io.IOException;
import java.sql.*;
import java.lang.ClassNotFoundException;
import javafx.stage.Stage;

public class LoginController  {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField passwordField;

    @FXML
    void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String name = txtName.getText();
        String password = DigestUtils.md5Hex(passwordField.getText());
        
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanly","root","");
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM user WHERE `name` = '" + name +"'"+ " AND `password` = '" + password+"'");
        while(rs.next()){
           App.setRoot("formFXML");
        }
        
    }
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void quit(ActionEvent event) {
        System.exit(0);
    }

}
