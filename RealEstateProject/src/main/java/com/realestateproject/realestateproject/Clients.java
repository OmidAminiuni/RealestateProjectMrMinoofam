package com.realestateproject.realestateproject;

import com.realestateproject.realestateproject.Model.Client;
import com.realestateproject.realestateproject.Model.Land;
import com.realestateproject.realestateproject.Model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Clients implements Initializable {
    public TextField txtClient;
    public TextField txtClientFather;
    Model db = new Model();

    public TableView<Client> tableViewClient1;
    public TableColumn<Land,String> clientName1;
    public TableColumn<Land,String> clientFather1;

    public Clients() throws SQLException {
    }

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

    public void updateTableClient(){
        clientName1.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        clientFather1.setCellValueFactory(new PropertyValueFactory<>("clientFatherName"));

        ObservableList<Client> observableListClient = null;
        observableListClient = FXCollections.observableArrayList(
                db.getAllClient()
        );
        tableViewClient1.setItems(observableListClient);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTableClient();
    }

    public void insertClient(ActionEvent actionEvent) throws SQLException {
        db.insertClient(new Client(1,1,txtClient.getText(),txtClientFather.getText(),"c://",0));
        updateTableClient();
    }

    public void deleteClient(ActionEvent actionEvent) throws SQLException {
        db.deleteClient(tableViewClient1.getSelectionModel().getSelectedItem().getClientID());
        updateTableClient();
    }
}
