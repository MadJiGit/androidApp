package com.madji.youtubetutorialapp.retrofitTutorial.data;

import com.google.gson.annotations.SerializedName;

public class AssetCoinData {

    @SerializedName("asset_id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("price_usd")
    private Double priceUSD;
    @SerializedName("type_is_crypto")
    private int isCrypto;

    public String getId() { return id; }
    public String getName() { return name; }
    public Double getPriceUSD() { return  this.priceUSD; }
    public Boolean isCrypto() { return isCrypto == 1; }

}
