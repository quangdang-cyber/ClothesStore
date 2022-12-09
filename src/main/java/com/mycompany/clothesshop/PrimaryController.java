package com.mycompany.clothesshop;
 
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
public class PrimaryController implements Initializable{
    @FXML
    private TableView<User> userTable;
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    
    @FXML
    private TableColumn<User, String> nameField;

    @FXML
    private TableColumn<User, String> passwordField;
    
     private ObservableList<User> userList;
     @Override
     public void initialize(URL location, ResourceBundle resources){
         userList = FXCollections.observableArrayList(
                new User("admin","123"),
                new User("admin", "admin")
        );
        nameField.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        passwordField.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        userTable.setItems(userList);
     }
    
}