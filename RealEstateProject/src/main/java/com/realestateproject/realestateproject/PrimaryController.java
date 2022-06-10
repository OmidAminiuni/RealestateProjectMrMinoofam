package com.realestateproject.realestateproject;

import java.io.IOException;
import java.sql.SQLException;

import com.realestateproject.realestateproject.Model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {
    Model db = new Model();
    public TextField password;
    public TextField username;

    public PrimaryController() throws SQLException {
    }

    @FXML
    private void switchToSecondary() throws IOException, SQLException {
        Integer pass  = Integer.valueOf(password.getText());
        String user = username.getText();
        if (pass == db.getPassword(user)){
            App.setRoot("secondary");
        }
    }
}
