package com.madji.youtubetutorialapp.retrofitTutorial.data;

import com.google.gson.annotations.SerializedName;

public class ExchangeCoinData {

    @SerializedName("exchange_id")
    private String id;
    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
