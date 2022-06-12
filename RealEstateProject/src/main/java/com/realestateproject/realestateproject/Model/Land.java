package com.realestateproject.realestateproject.Model;

public class Land {
    public int landID;
    public String landArea;
    public String landType;
    public String landAddress;
    public int landPrice;
    public int isAvailable;

    public Land(int landID, String landArea, String landType ,String landAddress,int landPrice,int isAvailable) {
        this.landID = landID;
        this.landArea = landArea;
        this.landType = landType;
        this.landAddress = landAddress;
        this.landPrice = landPrice;
        this.isAvailable = isAvailable;
    }

    public int getLandID() {
        return landID;
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

    public int getIsAvailable() {
        return isAvailable;
    }
}

