package com.realestateproject.realestateproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Clients {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void switchToBar(ActionEvent actionEvent) throws IOException {
        App.setRoot("buyingandrenting");
    }

    public void switchToSecondary(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }
}
