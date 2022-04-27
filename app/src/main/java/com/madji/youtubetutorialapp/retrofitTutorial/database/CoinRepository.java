package com.madji.youtubetutorialapp.retrofitTutorial.database;
import android.app.Application;

import androidx.lifecycle.LiveData;

import com.madji.youtubetutorialapp.retrofitTutorial.database.db_data.OneCoinData;

import java.util.List;

public class CoinRepository {

    private CoinsDatabaseInterface coinsDatabaseInterface;

    public CoinRepository(Application application) {
        CoinsAppDatabase db = CoinsAppDatabase.getDatabase(application);
        coinsDatabaseInterface = db.coinsDatabaseInterface();
    }

    public LiveData<List<OneCoinData>> getAllCoinsDataLD() {
        return coinsDatabaseInterface.getAlphabeticalOrderedCoinsLD();
    }
    public List<OneCoinData> getAllCoinsData() {
        return coinsDatabaseInterface.getListAlphabeticalOrderedCoins();
    }

    public void insert(OneCoinData oneCoinData) {
        CoinsAppDatabase.databaseWriteExecutor.execute(() -> {
            coinsDatabaseInterface.insert(oneCoinData);
        });
    }
}
