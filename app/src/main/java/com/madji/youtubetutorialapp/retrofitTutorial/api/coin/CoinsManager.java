package com.madji.youtubetutorialapp.retrofitTutorial.api.coin;

import com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces.ApiCallback;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api_data.AssetCoinData;

import java.util.ArrayList;
import java.util.List;

public class CoinsManager implements ApiCallback {
    private boolean isUpdated = false;
    private List<OneCoinData> allCoins = null;
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

    public List<OneCoinData> getAllCoinsList() {
       return this.allCoins;
    }

    public void addCoin(OneCoinData coin){
        allCoins.add(coin);
    }

    public void setAllCoinsList(List<OneCoinData> list){
        this.allCoins = list;
    }

    public OneCoinData getOneCoinByName(String name){

        OneCoinData coin = null;

        for (OneCoinData c : allCoins){
            if(c.getFullName().equals(name)){
                coin = c;
                break;
            }
        }

        return coin;
    }

    public boolean getIsUpdated(){
        return this.isUpdated;
    }

//    @Override
    public void onSuccess(List<AssetCoinData> result) {
            if(allCoins.size() > 0) {
                for(AssetCoinData acd : result){
                    for (OneCoinData ocd : allCoins){
                        if(ocd.getFullName().equals(acd.getName()) && ocd.getNickName().equals(acd.getId())){
                            ocd.setCurrentPrice(acd.getPriceUSD().toString());
                            break;
                        }
                    }
                }

                isUpdated = true;
            }
    }
}
