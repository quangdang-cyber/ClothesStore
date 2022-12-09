/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clothesshop;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;
import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.scene.control.Button;

 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;

import java.sql.*;
import java.lang.ClassNotFoundException;
import java.util.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.EventHandler;
    import javafx.scene.layout.*;
/**
 *
 * @author Admin
 */
public class SanPhamController implements Initializable{
    @FXML
    private TextField txtDecription;

    @FXML
    private TextField txtMadeBy;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtQuantity;
    @FXML
    private MenuItem back1;
    
    @FXML
    private MenuItem back;

    @FXML
    private TextField btsearch;

    @FXML
    private MenuBar menu;

    @FXML
    private TableColumn<SanPham, Integer> idField;

    @FXML
    private TableColumn<SanPham, String> nameField;
    @FXML
    private TableColumn<SanPham, String> madeByField;

    @FXML
    private TableColumn<SanPham, Double> priceField;
    @FXML
    private TableColumn<SanPham, String> descriptionField;

    @FXML
    private TableColumn<SanPham, Integer> quantityField;
    @FXML
    private TableView<SanPham> tbSP;
    private ObservableList<SanPham> sanPhamList;
    @Override
     public void initialize (URL location, ResourceBundle resources){
//         userList = FXCollections.observableArrayList(
//                new SanPham("admin","123"),
//                new SanPham("admin", "admin")
//        );
        
        boolean flag = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanly","root","");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM product ");
            List<SanPham> lsSanPham= new ArrayList<SanPham>();
            while(rs.next()){
               lsSanPham.add(new SanPham(rs.getInt("ID_Product") ,rs.getString("Name"), rs.getString("Quantity"), rs.getDouble("Price"),rs.getString("Description"), rs.getInt("RemainProduct")));
            }
            sanPhamList = FXCollections.observableList(
                   lsSanPham
            );
            idField.setCellValueFactory(new PropertyValueFactory<SanPham, Integer>("id"));
            nameField.setCellValueFactory(new PropertyValueFactory<SanPham, String>("name"));
            madeByField.setCellValueFactory(new PropertyValueFactory<SanPham, String>("madeBy"));
            priceField.setCellValueFactory(new PropertyValueFactory<SanPham, Double>("price"));
            descriptionField.setCellValueFactory(new PropertyValueFactory<SanPham, String>("description"));
            quantityField.setCellValueFactory(new PropertyValueFactory<SanPham, Integer>("quantity"));
            tbSP.setItems(sanPhamList);
            
            
        }catch(Exception e){
            flag = true;
        }
        if(flag == false){
           
        }
      
       
     }
     
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    public void about(ActionEvent event) {
//        Button button = new Button("button");
//   
//        // create a tile pane
//        TilePane tilepane = new TilePane();
//        Popup popup = new Popup();
//        Label label = new Label("This is a Popup");
//        label.setStyle(" -fx-background-color: white;");
//        popup.getContent().add(label);
//         label.setMinWidth(80);
//        label.setMinHeight(50);
//        popup.show((Stage) menu.getScene().getWindow());
//          EventHandler<ActionEvent> event = 
//        new EventHandler<ActionEvent>() {
//   
//            public void handle(ActionEvent e)
//            {
//                if (!popup.isShowing())
//                    popup.show(stage);
//                else
//                    popup.hide();
//            }
//        };
//   
//        // when button is pressed
//        button.setOnAction(event);
//   
//        // add button
//        tilepane.getChildren().add(button);
    }
    @FXML
    public void add (ActionEvent e){
        SanPham newSanPham = new SanPham();
        newSanPham.setName(txtName.getText());
        newSanPham.setMadeBy(txtMadeBy.getText());
        
//        newSanPham.setQuantity();
//        newSanPham.getPrice(txtName.getText());
        newSanPham.getDescription(txtName.getText());
        sanPhamList.add(newSanPham);
    }
    public void delete(ActionEvent e){
        SanPham selected = tbSP.getSelectionModel().getSelectedItem();
        sanPhamList.remove(selected);
    }
    public void backToMain(ActionEvent e) throws IOException{
        App.setRoot("formFXML");
    }
    @FXML
    public void choose(MouseEvent e){
        SanPham selected = tbSP.getSelectionModel().getSelectedItem();
        txtName.setText(selected.getName());
        txtMadeBy.setText(selected.getMadeBy());
        txtDecription.setText(selected.getDescription());
        txtPrice.setText(String.valueOf(selected.getPrice()));
        txtQuantity.setText(String.valueOf(selected.getQuantity()));
    }
    @FXML
    public void modify(ActionEvent e){
        SanPham sp = tbSP.getSelectionModel().getSelectedItem();
        sp.
    }
    
}
