package com.realestateproject.realestateproject.Model;

public class Land {
    public int landID;
    public String ownerName;
    public String landArea;
    public String landType;
    public String landAddress;
    public int landPrice;
    public String date;
    public int isAvailable;

    public Land(int landID, String ownerName, String landArea, String landType, String landAddress, int landPrice, String date, int isAvailable) {
        this.landID = landID;
        this.ownerName = ownerName;
        this.landArea = landArea;
        this.landType = landType;
        this.landAddress = landAddress;
        this.landPrice = landPrice;
        this.date = date;
        this.isAvailable = isAvailable;
    }

    public int getLandID() {
        return landID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getLandArea() {
        return landArea;
    }

    public String getLandType() {
        return landType;
    }

    public String getLandAddress() {
        return landAddress;
    }

    public int getLandPrice() {
        return landPrice;
    }

    public String getDate() {
        return date;
    }

    public int getIsAvailable() {
        return isAvailable;
    }
}

