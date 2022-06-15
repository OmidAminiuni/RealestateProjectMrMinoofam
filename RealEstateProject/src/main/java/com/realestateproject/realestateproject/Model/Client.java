package com.realestateproject.realestateproject.Model;

import java.util.Properties;

public class Client {
    int clientID ;
    int landID;
    String clientName;
    String clientFatherName;
    String clientCardPic;

    public Client(int clientID, int landID, String clientName, String clientFatherName, String clientCardPic) {
        this.clientID = clientID;
        this.landID = landID;
        this.clientName = clientName;
        this.clientFatherName = clientFatherName;
        this.clientCardPic = clientCardPic;
    }

    public int getClientID() {
        return clientID;
    }

    public int getLandID() {
        return landID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientFatherName() {
        return clientFatherName;
    }

    public String getClientCardPic() {
        return clientCardPic;
    }
}
