package com.realestateproject.realestateproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class SecondaryController implements Initializable{

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
   
    @FXML private ChoiceBox<String> myChoiceBox;
	
    private String[] type = {"Land","New-built House","Older than 5YO House"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {		
        myChoiceBox.getItems().addAll(type);
    }
    
    @FXML
    private void switchToBar() throws IOException {
        App.setRoot("buyingandrenting");
    }
   
}