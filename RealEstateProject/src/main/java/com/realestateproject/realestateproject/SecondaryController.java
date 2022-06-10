package com.realestateproject.realestateproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.realestateproject.realestateproject.Model.Client;
import com.realestateproject.realestateproject.Model.Land;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController implements Initializable{
    
    public TableView<Land> tableView1;
    public TableColumn<Land,String> owner;
    public TableColumn<Land,String> area;
    public TableColumn<Land,String> Type;
    public TableColumn<Land,String> address;
    public TableColumn<Land, Integer> price;
    public TableColumn<Land,String> date;


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
   
    @FXML private ChoiceBox<String> myChoiceBox;
	
    private String[] type = {"Land","New-built House","Older than 5YO House"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {		
        myChoiceBox.getItems().addAll(type);
        owner.setCellValueFactory(new PropertyValueFactory<>("landArea"));
        area.setCellValueFactory(new PropertyValueFactory<>("landArea"));
        Type.setCellValueFactory(new PropertyValueFactory<>("landType"));
        address.setCellValueFactory(new PropertyValueFactory<>("landAddress"));
        price.setCellValueFactory(new PropertyValueFactory<>("landPrice"));
        //date.setCellValueFactory(new PropertyValueFactory<>("ProductQuantity"));
        tableView1.setItems(observableList);
    }
    ObservableList<Land> observableList = FXCollections.observableArrayList(
            new Land(1,"2500","land","west",1000,1)
    );
    
    @FXML
    private void switchToBar() throws IOException {
        App.setRoot("buyingandrenting");
    }
   
}