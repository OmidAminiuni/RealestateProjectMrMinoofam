package com.realestateproject.realestateproject.Model;

import java.util.Properties;

public class Client {
    int clientID ;
    int landID;
    String clientName;
    String clientCardPic;

    public Client(int clientID, int landID, String clientName,String clientCardPic) {
        this.clientID = clientID;
        this.landID = landID;
        this.clientName = clientName;
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

    public String getClientCardPic() {
        return clientCardPic;
    }
}
