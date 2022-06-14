package com.realestateproject.realestateproject;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.realestateproject.realestateproject.Model.Client;
import com.realestateproject.realestateproject.Model.Land;
import com.realestateproject.realestateproject.Model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController implements Initializable{
    Model db = new Model();
    
    public TableView<Land> tableView1;
    public TableColumn<Land,String> owner;
    public TableColumn<Land,String> area;
    public TableColumn<Land,String> Type;
    public TableColumn<Land,String> address;
    public TableColumn<Land, Integer> price;
    public TableColumn<Land,String> date;

    public SecondaryController() throws SQLException {
    }


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void switchToClient() throws IOException {
        App.setRoot("Clients");
    }
    
   
    @FXML private ChoiceBox<String> myChoiceBox;
	
    private String[] type = {"Land","New-built House","Older than 5YO House"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(type);
        owner.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        area.setCellValueFactory(new PropertyValueFactory<>("landArea"));
        Type.setCellValueFactory(new PropertyValueFactory<>("landType"));
        address.setCellValueFactory(new PropertyValueFactory<>("landAddress"));
        price.setCellValueFactory(new PropertyValueFactory<>("landPrice"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        ObservableList<Land> observableList = null;
        try {
            observableList = FXCollections.observableArrayList(
//                    new Land(1,"2500","land","west",1000,1)
                    db.getAllLands()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tableView1.setItems(observableList);
    }


    
    @FXML
    private void switchToBar() throws IOException {
        App.setRoot("buyingandrenting");
    }
   
}