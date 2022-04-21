package com.madji.youtubetutorialapp.retrofitTutorial.data;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.madji.youtubetutorialapp.retrofitTutorial.database.CoinsDatabaseInterface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity(tableName = "my_coin_table")
@Dao
public class OneCoinData  {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public long id;

    @NonNull
    @ColumnInfo(name = "exchange_id")
    public String fullName;

    @NonNull
    @ColumnInfo(name = "nick_name")
    public String nickName;

    @ColumnInfo(name = "amount")
    public String amount;

    @NonNull
    @ColumnInfo(name = "data_purchased")
    public String dataPurchased;

    @NonNull
    @ColumnInfo(name = "purchase_price")
    public String purchasePrice;


    public OneCoinData(String fullName, String nickName, String amount, String dataPurchased, String purchasePrice){
        setFullName(fullName);
        setNickName(nickName);
        setAmount(amount);
        setDataPurchased(dataPurchased);
        setPurchasePrice(purchasePrice);
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

    public void setFullName(@NonNull String fullName) {
        this.fullName = fullName;
    }

    public void setNickName(@NonNull String nickName) {
        this.nickName = nickName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDataPurchased(@NonNull String dataPurchased) {
        this.dataPurchased = dataPurchased;
    }

    public void setPurchasePrice(@NonNull String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public long getId() {
        return id;
    }
}
