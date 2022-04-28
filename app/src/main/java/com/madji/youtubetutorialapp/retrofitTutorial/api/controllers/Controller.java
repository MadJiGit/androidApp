package com.madji.youtubetutorialapp.retrofitTutorial.api.controllers;

import static com.madji.youtubetutorialapp.retrofitTutorial.api.controllers.GetRetroFit.getRetroFit;

import com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces.ApiCallback;
import com.madji.youtubetutorialapp.retrofitTutorial.api.constants.Credentials;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces.ApiService;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api_data.AssetCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api_data.ExchangeCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces.models.Model;

import java.util.List;

import retrofit2.Retrofit;

public class Controller {

    public void getAssetCoinData(ApiCallback callback) {

        Retrofit retrofit = getRetroFit(Credentials.API_KEY, Credentials.API_KEY_VALUE);
        ApiService service = retrofit.create(ApiService.class);
        Model<List<AssetCoinData>> ac2 = new Model<>(service.loadCoinsAssetsData());
        Model<List<ExchangeCoinData>> ac1 = new Model<>(service.loadCoinsExchangeData());


        ac2.doRequest(new ApiCallback() {
            @Override
            public List onSuccess(Object result) {
                return (List)result;
            }
        });

//        ac2.doRequest(result -> {
//            List<AssetCoinData> assetCoinData = (List<AssetCoinData>) result;
//            int count = 0;
//            for (AssetCoinData l : assetCoinData) {
//                if (l.isCrypto() && l.getPriceUSD() != null) {
//                    count++;
//                    String res = String.format("Coin name %s\t\tprice in $USD %f", l.getName(), l.getPriceUSD());
//                    System.out.println(res.trim());
////                    System.out.println("Coin name " + l.getName() + "\t\t\tprice in $USD " + l.getPriceUSD());
//                }
//            }
//            System.out.println("total coins data is: " + count);
//            return assetCoinData;
//        });
    }


}

    /*
    public void start() {

        Retrofit retrofit = getRetroFit(Credentials.API_KEY, Credentials.API_KEY_VALUE);
        ApiService service = retrofit.create(ApiService.class);
        Model<List<AssetCoinData>> ac2 = new Model<>(service.loadCoinsAssetsData());
        Model<List<ExchangeCoinData>> ac1 = new Model<>(service.loadCoinsExchangeData());

        ac2.doRequest(result -> {
            assetCoinData =  (List<AssetCoinData>) result;
            int count = 0;
            for (AssetCoinData l : assetCoinData){
                if(l.isCrypto() && l.getPriceUSD() != null) {
                    count++;
                    String res = String.format("Coin name %s\t\tprice in $USD %f", l.getName(), l.getPriceUSD());
                    System.out.println(res.trim());
//                    System.out.println("Coin name " + l.getName() + "\t\t\tprice in $USD " + l.getPriceUSD());
                }
            }
            System.out.println("total coins data is: " + count);
            return assetCoinData;
        });
*/
//        ac1.doRequest(result -> {
//            int count = 0;
//            List<ExchangeCoinData> ll =  (List<ExchangeCoinData>) result;
//            for (ExchangeCoinData l : ll){
//                System.out.println("----- " + l.getId());
//                if(count++ == 10){
//                    break;
//                }
//            }
//            return ll;
//        });

/*

working callback
        ac1.doRequest(new ApiCallback() {
            @Override
            public void onSuccess(Object result) {
                int counter = 0;
                List<ExchangeCoinData> list =  (List<ExchangeCoinData>) result;
                for (ExchangeCoinData ncd : list) {
                    System.out.println("new " + counter++ + " exchange_id: " + ncd.getExchange_id() + " name: " + ncd.getName());
                }

            }
        });
 */
