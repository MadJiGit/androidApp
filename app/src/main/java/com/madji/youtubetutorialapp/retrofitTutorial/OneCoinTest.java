package com.madji.youtubetutorialapp.retrofitTutorial;

import com.google.gson.annotations.SerializedName;

public class OneCoinTest {

    private String id;
    private String name;
    private String symbol;
    private int market_cap_rank;
    private String thumb;
    private String image;

//    @SerializedName("body")
//    private String body;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getMarket_cap_rank() {
        return market_cap_rank;
    }

    public String getThumb() {
        return thumb;
    }

    public String getImage() {
        return image;
    }
}
