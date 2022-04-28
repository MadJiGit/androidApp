package com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces;

import com.madji.youtubetutorialapp.retrofitTutorial.api.api_data.AssetCoinData;

import java.util.List;

public interface ApiCallback<T> {
//    void onSuccess(List<NewCoinData> result);
//    void onSuccess(T result);
    List<T> onSuccess(T result);
}

//public interface ApiCallback {
//    //    void onSuccess(List<NewCoinData> result);
////    void onSuccess(T result);
//    void getAssetsCoinData(List<AssetCoinData>);
//}