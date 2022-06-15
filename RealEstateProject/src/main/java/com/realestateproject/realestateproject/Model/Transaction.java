package com.realestateproject.realestateproject.Model;

public class Transaction {
    int transactionID;
    String transactionOwner;
    String transactionBuyer;
    String transactionAddress;
    String transactionPrice;

    public Transaction(int transactionID, String transactionOwner, String transactionBuyer, String transactionAddress, String transactionPrice) {
        this.transactionID = transactionID;
        this.transactionOwner = transactionOwner;
        this.transactionBuyer = transactionBuyer;
        this.transactionAddress = transactionAddress;
        this.transactionPrice = transactionPrice;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public String getTransactionOwner() {
        return transactionOwner;
    }

    public String getTransactionBuyer() {
        return transactionBuyer;
    }

    public String getTransactionAddress() {
        return transactionAddress;
    }

    public String getTransactionPrice() {
        return transactionPrice;
    }
}
