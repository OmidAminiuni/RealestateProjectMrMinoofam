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
                land = new Land(rs.getInt("landID"), rs.getString("landArea"), rs.getString("landType"),rs.getString("landAddress"),rs.getInt("landPrice"),rs.getInt("isAvailable"));
                landsList.add(land);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return landsList;
        }
        return landsList;
    }

    @Override
    public List<Client> getAllClient() {
        ArrayList<Client> clientsList = new ArrayList<>();
        try {
            String query1 = "SELECT * FROM clients WHERE isDelete != 1";
            rs = statement.executeQuery(query1);
            Client client;
            while (rs.next()) {
                client = new Client(rs.getInt("clientID"), rs.getInt("landID"), rs.getString("clientName"),rs.getString("clientCardPic"));
                clientsList.add(client);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return clientsList;
        }
        return clientsList;
    }

    @Override
    public Land getLandById(int id) throws SQLException {
        String query1 = String.format("SELECT * FROM lands where landID = %s ",id);
        rs = statement.executeQuery(query1);
        Land land = null;
        while (rs.next()) {
            land = new Land(rs.getInt("landID"), rs.getString("landArea"), rs.getString("landType"),rs.getString("landAddress"),rs.getInt("isAvailable"),rs.getInt("isAvailable"));
        }
        return land;
    }

    @Override
    public Client getClientById(int id) throws SQLException {
        String query1 = String.format("SELECT * FROM clients where clientID = %s ",id);
        rs = statement.executeQuery(query1);
        Client client = null;
        while (rs.next()) {
            client = new Client(rs.getInt("clientID"), rs.getInt("landID"), rs.getString("clientName"), rs.getString("clientCardPic"));
        }
        return client;
    }

    @Override
    public void insertLand(Land land) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(String.format("INSERT INTO lands ( landArea ,landType,landAddress,landPrice,isAvailable) VALUES (%s,'%s','%s',%s,%s);", land.getLandArea(),land.getLandType(),land.getLandAddress(),land.getLandPrice(),land.getIsAvailable()));
        pst.executeUpdate();
    }

    @Override
    public void insertClient(Client client) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(String.format("INSERT INTO clients (landID ,clientName,clientCardPic) VALUES ('%s','%s','%s');",client.getLandID(),client.getClientName(),client.getClientCardPic()));
        pst.executeUpdate();
    }

    @Override
    public void updateLand(Land land) throws SQLException {
        String query = String.format("UPDATE lands SET landArea = '%s' , landType = '%s',landAddress = '%s',landPrice = %s, isAvailable = %s WHERE landID = %s ;",land.getLandArea(),land.getLandType() ,land.getLandAddress() ,land.getLandPrice() ,land.getIsAvailable() ,land.getLandID());
        PreparedStatement pst = connection.prepareStatement(query);
        pst.executeUpdate();
    }

    @Override
    public void updateClient(Client client) throws SQLException {
        String query = String.format("UPDATE clients SET landID = %s , clientName = '%s', clientCardPic = '%s' WHERE clientID = %s ;",client.getLandID(),client.getClientName() ,client.getClientCardPic(), client.getClientID());
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
