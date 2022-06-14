package com.realestateproject.realestateproject.Model;

public class Owner {
    int ownerID;
    String ownerName;
    String ownerFather;
    String ownerCartIdPath;

    public Owner(int ownerID, String ownerName, String ownerFather, String ownerCartIdPath) {
        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.ownerFather = ownerFather;
        this.ownerCartIdPath = ownerCartIdPath;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerFather() {
        return ownerFather;
    }

    public String getOwnerCartIdPath() {
        return ownerCartIdPath;
    }
}
