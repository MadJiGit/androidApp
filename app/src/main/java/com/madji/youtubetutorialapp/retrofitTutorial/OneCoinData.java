package com.madji.youtubetutorialapp.retrofitTutorial;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.GET;

public class OneCoinData {

    @SerializedName("bitcoin")
    private OneCoinTest oneCoinData;

    public OneCoinTest getOneCoinData(){
        return this.oneCoinData;
    }

    /*
{
  "bitcoin": {
    "usd": 41194
  },
  "cardano": {
    "usd": 0.954587
  },
  "terra-luna": {
    "usd": 87.08
  }
}
 */
}
