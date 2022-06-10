package com.realestateproject.realestateproject.Model;

import java.sql.SQLException;
import java.util.List;

public interface IModel {
    List<Land> getAllLands() throws SQLException, ClassNotFoundException;
    List<Client> getAllClient();
    Land getLandById(int id) throws SQLException;
    Client getClientById(int id) throws SQLException;
    void insertLand(Land land) throws SQLException;
    void insertClient(Client client) throws SQLException;
    void updateLand(Land land) throws SQLException;
    void updateClient(Client client) throws SQLException;
    void deleteLand(int ID) throws SQLException;
    void deleteClient(int ID) throws SQLException;
    int getPassword(String user) throws SQLException;
}
