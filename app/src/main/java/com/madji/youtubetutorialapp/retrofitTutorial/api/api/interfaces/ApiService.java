package com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api_data.AssetCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api_data.ExchangeCoinData;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

//    @GET("exchanges?apikey=")
    @GET("exchanges?")
//    @GET("exchanges?apikey=3CCDC3B6-F709-4544-86F9-69888FB0C543")
    Call<List<ExchangeCoinData>> loadCoinsExchangeData();

    @GET("assets?")
    Call<List<AssetCoinData>> loadCoinsAssetsData();

}
