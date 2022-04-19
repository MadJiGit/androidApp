package com.madji.youtubetutorialapp.retrofitTutorial.database;
import android.app.Application;

import androidx.lifecycle.LiveData;

import com.madji.youtubetutorialapp.retrofitTutorial.data.OneCoinData;

import java.util.List;

public class CoinRepository {

    private CoinsDatabaseInterface coinsDatabaseInterface;
    private LiveData<List<OneCoinData>> allCoinsData;

    public CoinRepository(Application application) {
        CoinsAppDatabase db = CoinsAppDatabase.getDatabase(application);
        coinsDatabaseInterface = db.coinsDatabaseInterface();
        allCoinsData = coinsDatabaseInterface.getAlphabeticalOrderedCoins();
    }

    public LiveData<List<OneCoinData>> getAllCoinsData() {
        return allCoinsData;
    }

    public void insert(OneCoinData oneCoinData) {
        CoinsAppDatabase.databaseWriteExecutor.execute(() -> {
            coinsDatabaseInterface.insert(oneCoinData);
        });
    }

    public void close() {
    }
}
