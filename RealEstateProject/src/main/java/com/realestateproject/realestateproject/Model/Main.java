package com.realestateproject.realestateproject.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Model db = new Model();
        //System.out.println(db.getAllLands().get(1).getLandNumber().toString());
        ArrayList<Land> list = (ArrayList<Land>) db.getAllLands();
        ArrayList<Client> clientList = (ArrayList<Client>) db.getAllClient();
        ArrayList<Owner> ownerslist = (ArrayList<Owner>) db.getAllOwners();
        //ystem.out.println(list.get(2).getLandNumber());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getLandAddress());
        }
        System.out.println("----------------------");
        System.out.println(clientList.get(0).getClientName());
        System.out.println(ownerslist.get(1).getOwnerName());
        System.out.println(list.get(1).getLandAddress());
        System.out.println(list.get(2).getLandAddress());
        System.out.println(list.get(2).getLandType());
        System.out.println(db.getPassword("arvin"));
        //System.out.println(12);
        //-------------------lands done
        //System.out.println(db.getLandById(5).getLandNumber());
        //------------------inserts
        //Land land = new Land(5000, "2","land","30",0);
        //db.insertLand(land);
        //--------------------update
        //point : we must create land with same id as land we want to edit and other sell can be different for edit
        //Land land1 = new Land(1, "20","Building","15",1);
        //db.updateLand(land1);
        //-----------------------------delete
        //db.deleteLand(1);

    }
}
