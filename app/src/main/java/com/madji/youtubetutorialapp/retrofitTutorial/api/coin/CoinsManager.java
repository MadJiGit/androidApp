package com.madji.youtubetutorialapp.retrofitTutorial.api.coin;

import java.util.ArrayList;

public class CoinsManager {
    private ArrayList<OneCoinData> allCoins;
    static CoinsManager coinsManager = null;
    private CoinsManager(){
        allCoins = new ArrayList<>();
    }

    public static CoinsManager getCoinsManager(){
        if(coinsManager == null){
            coinsManager = new CoinsManager();
        }

        return coinsManager;
    }

    public ArrayList<OneCoinData> getAllCoinsList() {
       return this.allCoins;
    }

    public void addCoin(OneCoinData coin){
        allCoins.add(coin);
    }

    public void setAllCoinsList(ArrayList<OneCoinData> list){
        this.allCoins = list;
    }

    public OneCoinData getOneCoinByName(String name){

        OneCoinData coin = null;

        for (OneCoinData c : allCoins){
            if(c.fullName.equals(name)){
                coin = c;
                break;
            }
        }

        return coin;
    }
}
