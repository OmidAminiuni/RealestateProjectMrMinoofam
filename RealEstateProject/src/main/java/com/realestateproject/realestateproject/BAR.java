
package com.realestateproject.realestateproject;

import com.realestateproject.realestateproject.Model.Client;
import com.realestateproject.realestateproject.Model.Land;
import com.realestateproject.realestateproject.Model.Model;
import com.realestateproject.realestateproject.Model.Owner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BAR implements Initializable {
    Model db = new Model();

    public TableView<Land> tableViewBar;
    public TableColumn<Land,String> owner;
    public TableColumn<Land,String> area;
    public TableColumn<Land,String> Type;
    public TableColumn<Land,String> address;
    public TableColumn<Land, Integer> price;
    public TableColumn<Land,String> date;

    public TableView<Owner> tableViewOwner;
    public TableColumn<Land,String> ownerName;
    public TableColumn<Land,String> ownerFather;

    public TableView<Client> tableViewClient;
    public TableColumn<Land,String> clientName;
    public TableColumn<Land,String> clientFatherName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        owner.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        area.setCellValueFactory(new PropertyValueFactory<>("landArea"));
        Type.setCellValueFactory(new PropertyValueFactory<>("landType"));
        address.setCellValueFactory(new PropertyValueFactory<>("landAddress"));
        price.setCellValueFactory(new PropertyValueFactory<>("landPrice"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        ownerName.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        ownerFather.setCellValueFactory(new PropertyValueFactory<>("ownerFather"));

        ownerName.setCellValueFactory(new PropertyValueFactory<>("clientName"));


        ObservableList<Client> observableListClient = null;
        observableListClient = FXCollections.observableArrayList(
                db.getAllClient()
        );
        tableViewClient.setItems(observableListClient);

        ObservableList<Owner> observableListOwner = null;
        try {
            observableListOwner = FXCollections.observableArrayList(
//                    new Owner(1,"arvin","salehi","c://")
                    db.getAllOwners()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tableViewOwner.setItems(observableListOwner);

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
        tableViewBar.setItems(observableList);
    }

    public BAR() throws SQLException {
    }

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
