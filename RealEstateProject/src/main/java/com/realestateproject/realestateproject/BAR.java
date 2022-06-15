
package com.realestateproject.realestateproject;

import com.realestateproject.realestateproject.Model.Client;
import com.realestateproject.realestateproject.Model.Land;
import com.realestateproject.realestateproject.Model.Model;
import com.realestateproject.realestateproject.Model.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BAR implements Initializable {
    public TextField txtOwnerT;
    public TextField txtBuyerT;
    public TextField txtAddressT;
    public TextField txtPriceT;
    public TableView<Transaction> tableViewTransaction;
    public TableColumn<Object, Object> transactionOwner;
    public TableColumn<Object, Object> transactionBuyer;
    public TableColumn<Object, Object> transactionAddress;
    public TableColumn<Object, Object> transactionPrice;
    Model db = new Model();

    public TableView<Land> tableViewBar;
    public TableColumn<Land,String> owner;
    public TableColumn<Land,String> area;
    public TableColumn<Land,String> Type;
    public TableColumn<Land,String> address;
    public TableColumn<Land, Integer> price;
    public TableColumn<Land,String> date;

    public TableView<Client> tableViewClient;
    public TableColumn<Land,String> clientName;
    public TableColumn<Land,String> clientFather;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceBox.getItems().addAll(type);
        owner.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        area.setCellValueFactory(new PropertyValueFactory<>("landArea"));
        Type.setCellValueFactory(new PropertyValueFactory<>("landType"));
        address.setCellValueFactory(new PropertyValueFactory<>("landAddress"));
        price.setCellValueFactory(new PropertyValueFactory<>("landPrice"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        clientFather.setCellValueFactory(new PropertyValueFactory<>("clientFatherName"));

        transactionOwner.setCellValueFactory(new PropertyValueFactory<>("transactionOwner"));
        transactionBuyer.setCellValueFactory(new PropertyValueFactory<>("transactionBuyer"));
        transactionAddress.setCellValueFactory(new PropertyValueFactory<>("transactionAddress"));
        transactionPrice.setCellValueFactory(new PropertyValueFactory<>("transactionPrice"));

        ObservableList<Transaction> observableListTransactionPrice = null;
        observableListTransactionPrice = FXCollections.observableArrayList(
//                    new Land(1,"2500","land","west",1000,1)
                db.getAllTransaction()
        );
        tableViewTransaction.setItems(observableListTransactionPrice);


        ObservableList<Client> observableListClient = null;
        observableListClient = FXCollections.observableArrayList(
                db.getAllClient()
        );
        tableViewClient.setItems(observableListClient);


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

    @FXML private ChoiceBox<String> ChoiceBox;

    private String[] type = {"Buy","Rent"};


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

    public void insertTransaction(ActionEvent actionEvent) throws SQLException {
        db.insertTransaction(new Transaction(1,txtOwnerT.getText(),txtBuyerT.getText(),txtAddressT.getText(),txtPriceT.getText()));
    }
}
