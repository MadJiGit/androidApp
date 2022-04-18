package com.madji.youtubetutorialapp.retrofitTutorial;

public interface ApiCallback<T> {
//    void onSuccess(List<NewCoinData> result);
    void onSuccess(T result);
}

