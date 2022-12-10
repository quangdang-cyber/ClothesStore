/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clothesshop;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;

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
    private TextField txtSearch;
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
    public void khuyenMai(ActionEvent event) throws IOException {
        App.setRoot("KhuyenMai");
    }
    @FXML
    public void thongKe(ActionEvent event) throws IOException{
        App.setRoot("ThongKe");
    }
    @FXML
    public void thanhToan(ActionEvent event) throws IOException{
        App.setRoot("ThanhToan");
    }
    @FXML
    public void about(ActionEvent event) throws IOException{
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
        try{
            SanPham newSanPham = new SanPham();
            newSanPham.setName(txtName.getText());
            newSanPham.setMadeBy(txtMadeBy.getText());

            newSanPham.setQuantity(Integer.valueOf(txtQuantity.getText()));
            newSanPham.setPrice(Double.valueOf(txtPrice.getText()));
            newSanPham.setDescription(txtName.getText());
            sanPhamList.add(newSanPham);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanly","root","");
            PreparedStatement update = conn.prepareStatement("INSERT INTO product (Name, Quantity, Price, Description, RemainProduct) VALUES (?, ?, ?, ?, ?)");
            update.setString(1, newSanPham.getName());
            update.setString(2, newSanPham.getMadeBy());
            update.setString(3, String.valueOf(newSanPham.getPrice()));
            update.setString(4, newSanPham.getDescription());
            update.setString(5, String.valueOf(newSanPham.getQuantity()));
            int row = update.executeUpdate();
            System.out.println(row);
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanly","root","");
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
        } catch (Exception ex){
            System.err.println(ex);
        }
       
    }
    public void delete(ActionEvent e){
        try{
            SanPham selected = tbSP.getSelectionModel().getSelectedItem();
            sanPhamList.remove(selected);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanly","root","");
            PreparedStatement update = conn.prepareStatement("DELETE FROM product WHERE ID_Product = ?");
            update.setString(1, String.valueOf(selected.getId()));
            int row = update.executeUpdate();
            System.out.println(row);
        } catch (Exception ex){
            System.out.println(ex);
        }
       
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
        try{
            SanPham sp = tbSP.getSelectionModel().getSelectedItem();
            System.out.println(sp.getId());
            sp.setName(txtName.getText());
            sp.setQuantity(Integer.valueOf(txtQuantity.getText()));
            sp.setPrice(Double.valueOf(txtPrice.getText()));
            sp.setDescription(txtDecription.getText());
            sp.setMadeBy(txtMadeBy.getText());
            System.out.println(sp.getId());
            tbSP.toFront();
            tbSP.refresh();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanly","root","");
            PreparedStatement update = conn.prepareStatement("UPDATE product SET name = ?, quantity = ?, price = ?, description = ?, RemainProduct = ? WHERE ID_Product = ?");
            update.setString(1, sp.getName());
            update.setString(2, sp.getMadeBy());
            update.setString(3, String.valueOf(sp.getPrice()));
            update.setString(4, sp.getDescription());
            update.setString(5, String.valueOf(sp.getQuantity()));
            update.setString(6, String.valueOf(sp.getId()));
                    
            
            int row = update.executeUpdate();
            System.out.println(row);
        } catch(Exception ex){
            System.out.println(ex);
        }
    }
    @FXML
     public void search(KeyEvent e){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanly","root","");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM product WHERE Name LIKE '%"+ txtSearch.getText() +"%'");
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
            }catch(Exception ex){
                System.out.println(ex);
            }
        
    }
}
