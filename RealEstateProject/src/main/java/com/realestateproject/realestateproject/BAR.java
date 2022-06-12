
package com.realestateproject.realestateproject;

import javafx.event.ActionEvent;

import java.io.IOException;

public class BAR {

    public void switchToPrimary(ActionEvent actionEvent) throws IOException {
        App.setRoot("primary");
    }


    public void switchToSecondary(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }
    public void switchToClient(ActionEvent actionEvent) throws IOException {
        App.setRoot("Clients");
    }
}
