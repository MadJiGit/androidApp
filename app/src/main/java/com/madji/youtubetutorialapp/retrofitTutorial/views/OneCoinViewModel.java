package com.madji.youtubetutorialapp.retrofitTutorial.views;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.madji.youtubetutorialapp.retrofitTutorial.data.OneCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.database.CoinRepository;

import java.util.List;

public class OneCoinViewModel extends AndroidViewModel {

    private CoinRepository coinRepository;
    private LiveData<List<OneCoinData>> allCoinsDataLD;
    private List<OneCoinData> allCoinsData;

    public OneCoinViewModel(@NonNull Application application) {
        super(application);
        coinRepository = new CoinRepository(application);
    }

    public LiveData<List<OneCoinData>> getAllCoinsDataLD() {
        extractAllCoinsDataLD();
        return allCoinsDataLD;
    }

    public List<OneCoinData> getAllCoinsData() {
        extractAllCoinsData();
        return allCoinsData;
    }

    private void extractAllCoinsData() {
        this.coinRepository.getAllCoinsData();
    }

    private void extractAllCoinsDataLD() {
        this.allCoinsDataLD = coinRepository.getAllCoinsDataLD();
    }


    public void insert (OneCoinData oneCoinData) {
        coinRepository.insert(oneCoinData);
    }
}
