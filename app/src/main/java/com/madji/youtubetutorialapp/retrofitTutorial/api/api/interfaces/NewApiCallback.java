package com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces;

import com.madji.youtubetutorialapp.retrofitTutorial.api.api_data.AssetCoinData;

import java.util.List;

public interface NewApiCallback<T> {
    void getList(List<AssetCoinData> list);
}
