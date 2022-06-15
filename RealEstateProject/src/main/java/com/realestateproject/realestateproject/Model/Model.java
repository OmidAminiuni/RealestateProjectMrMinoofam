package com.realestateproject.realestateproject.Model;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model implements IModel{
    public String connectionUrl = "jdbc:jtds:sqlserver://Arvin:1433/Housing_DB;instance=MSSQLSERVER";
    Connection connection = DriverManager.getConnection(connectionUrl);
    Statement statement = connection.createStatement();
    ResultSet rs ;

    public Model() throws SQLException {
    }


    @Override
    public List<Land> getAllLands() throws SQLException, ClassNotFoundException {
        ArrayList<Land> landsList = new ArrayList<>();
        try {
            String query1 = "SELECT * FROM lands WHERE isDelete != 1";
            rs = statement.executeQuery(query1);
            Land land;
            while (rs.next()) {
                land = new Land(rs.getInt("landID"),rs.getString("ownerName"),  rs.getString("landArea"), rs.getString("landType"),rs.getString("landAddress"),rs.getInt("landPrice"),rs.getString("date"),rs.getInt("isAvailable"),rs.getInt("isDelete"));
                landsList.add(land);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return landsList;
        }
        return landsList;
    }

    @Override
    public List<Owner> getAllOwners() throws SQLException, ClassNotFoundException {
        ArrayList<Owner> ownersList = new ArrayList<>();
        try {
            String query1 = "SELECT * FROM owners";
            rs = statement.executeQuery(query1);
            Owner owner;
            while (rs.next()) {
                owner = new Owner(rs.getInt("ownerID"),rs.getString("ownerName"),rs.getString("ownerFather"),rs.getString("ownerCardIdPath"));
                ownersList.add(owner);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return ownersList;
        }
        return ownersList;
    }

    @Override
    public List<Client> getAllClient() {
        ArrayList<Client> clientsList = new ArrayList<>();
        try {
            String query1 = "SELECT * FROM clients WHERE isDelete != 1";
            rs = statement.executeQuery(query1);
            Client client;
            while (rs.next()) {
                client = new Client(rs.getInt("clientID"), rs.getInt("landID"), rs.getString("clientName"), rs.getString("clientFatherName"),rs.getString("clientCardPic"),rs.getInt("isDelete"));
                clientsList.add(client);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return clientsList;
        }
        return clientsList;
    }

    @Override
    public List<Transaction> getAllTransaction() {
        ArrayList<Transaction> transactionsList = new ArrayList<>();
        try {
            String query1 = "SELECT * FROM transactions ";
            rs = statement.executeQuery(query1);
            Transaction transaction;
            while (rs.next()) {
                transaction = new Transaction(rs.getInt("transactionID"), rs.getString("transactionOwner"), rs.getString("transactionBuyer"), rs.getString("transactionAddress"),rs.getString("transactionPrice"));
                transactionsList.add(transaction);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return transactionsList;
        }
        return transactionsList;
    }

    @Override
    public Land getLandById(int id) throws SQLException {
        String query1 = String.format("SELECT * FROM lands where landID = %s ",id);
        rs = statement.executeQuery(query1);
        Land land = null;
        while (rs.next()) {
            land = new Land(rs.getInt("landID"),rs.getString("ownerName"),  rs.getString("landArea"), rs.getString("landType"),rs.getString("landAddress"),rs.getInt("landPrice"),rs.getString("date"),rs.getInt("isAvailable"),rs.getInt("isDelete"));
        }
        return land;
    }

    @Override
    public Client getClientById(int id) throws SQLException {
        String query1 = String.format("SELECT * FROM clients where clientID = %s ",id);
        rs = statement.executeQuery(query1);
        Client client = null;
        while (rs.next()) {
            client = new Client(rs.getInt("clientID"), rs.getInt("landID"), rs.getString("clientName"), rs.getString("clientFatherName"), rs.getString("clientCardPic"), rs.getInt("isDelete"));
        }
        return client;
    }

    @Override
    public void insertLand(Land land) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(String.format("INSERT INTO lands (ownerName , landArea ,landType,landAddress,landPrice,date,isAvailable,isDelete) VALUES ('%s', %s,'%s','%s',%s,%s,'%s','%s');",land.getOwnerName(), land.getLandArea(),land.getLandType(),land.getLandAddress(),land.getLandPrice(),land.getDate(),land.getIsAvailable(), land.getIsDelete()));
        pst.executeUpdate();
    }

    @Override
    public void insertClient(Client client) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(String.format("INSERT INTO clients (landID ,clientName,clientFatherName,clientCardPic,isDelete) VALUES ('%s','%s','%s','%s','%s');",client.getLandID(),client.getClientName(),client.getClientFatherName(),client.getClientCardPic(),client.getIsDelete()));
        pst.executeUpdate();
    }

    @Override
    public void insertTransaction(Transaction transaction) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(String.format("INSERT INTO transactions (transactionOwner,transactionBuyer,transactionAddress,transactionPrice) VALUES ('%s','%s','%s','%s');",transaction.getTransactionOwner(),transaction.getTransactionBuyer(),transaction.getTransactionAddress(),transaction.getTransactionPrice()));
        pst.executeUpdate();
    }

    @Override
    public void updateLand(Land land) throws SQLException {
        String query = String.format("UPDATE lands SET ownerName = '%s', landArea = '%s' , landType = '%s',landAddress = '%s',landPrice = %s, date = '%s' ,isAvailable = %s WHERE landID = %s ;",land.getOwnerName(),land.getLandArea(),land.getLandType() ,land.getLandAddress() ,land.getLandPrice() ,land.getDate(),land.getIsAvailable() ,land.getLandID());
        PreparedStatement pst = connection.prepareStatement(query);
        pst.executeUpdate();
    }

    @Override
    public void updateClient(Client client) throws SQLException {
        String query = String.format("UPDATE clients SET landID = %s , clientName = '%s', clientName = '%s', clientCardPic = '%s' WHERE clientID = %s ;",client.getLandID(),client.getClientName(),client.getClientFatherName() ,client.getClientCardPic(), client.getClientID());
        PreparedStatement pst = connection.prepareStatement(query);
        pst.executeUpdate();
    }

    @Override
    public void deleteLand(int ID) throws SQLException {
        String query = String.format("UPDATE lands SET isDelete = %s WHERE landID = %s ;", 1, ID);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.executeUpdate();
    }

    @Override
    public void deleteClient(int ID) throws SQLException {
        String query = String.format("UPDATE clients SET isDelete = %s WHERE clientID = %s ;", 1, ID);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.executeUpdate();
    }

    @Override
    public int getPassword(String user) throws SQLException {
        String query1 = String.format("SELECT password FROM login where userName = '%s' ",user);
        rs = statement.executeQuery(query1);
        int pass = 0;
        while (rs.next()) {
            pass = rs.getInt("password");
        }
        return pass;
    }


}
