module com.realestateproject.realestateproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.realestateproject.realestateproject to javafx.fxml;
    exports com.realestateproject.realestateproject;
    opens com.realestateproject.realestateproject.Model to javafx.fxml;
    exports com.realestateproject.realestateproject.Model;

}
