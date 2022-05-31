module com.realestateproject.realestateproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.realestateproject.realestateproject to javafx.fxml;
    exports com.realestateproject.realestateproject;
}
