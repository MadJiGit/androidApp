package com.madji.youtubetutorialapp.retrofitTutorial.views;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CoinDataAppView {

    final private String nickName;
    final private String fullName;
    final private String amount;
    final private String dataPurchased;
    final private String purchasePrice;

    CoinDataAppView(String nickName, String fullName, String amount, String price){
        this.nickName = nickName;
        this.fullName = fullName;
        this.amount = amount;
        this.purchasePrice = price;
        this.dataPurchased = getPurchaseData();
    }

    private String getPurchaseData() {
        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return df.format(date);
    }

    public String getNickName() {
        return nickName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAmount() {
        return amount;
    }

    public String getDataPurchased() {
        return dataPurchased;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }


}
