package com.madji.youtubetutorialapp.retrofitTutorial.api.coin;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.io.Serializable;

public class OneCoinData implements Serializable {
    private String fullName;
    private String nickName;
    private String amount;
    private String dataPurchased;
    private String purchasePrice;
    private String currentPrice;

    public OneCoinData(String fullName, String nickName, String amount, String dataPurchased, String purchasePrice) {
        this.setFullName(fullName);
        this.setNickName(nickName);
        this.setAmount(amount);
        this.setDataPurchased(dataPurchased);
        this.setPurchasePrice(purchasePrice);
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDataPurchased() {
        return dataPurchased;
    }

    public void setDataPurchased(String dataPurchased) {
        this.dataPurchased = dataPurchased;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
