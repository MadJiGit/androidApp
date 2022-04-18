package com.madji.youtubetutorialapp.retrofitTutorial.interfaces;

import java.util.List;

public interface ApiCallback<T> {
//    void onSuccess(List<NewCoinData> result);
//    void onSuccess(T result);
    List<T> onSuccess(T result);
}

