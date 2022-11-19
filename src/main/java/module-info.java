module com.mycompany.clothesshop {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.clothesshop to javafx.fxml;
    exports com.mycompany.clothesshop;
}
