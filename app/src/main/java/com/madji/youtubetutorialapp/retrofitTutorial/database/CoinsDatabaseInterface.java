package com.madji.youtubetutorialapp.retrofitTutorial.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.madji.youtubetutorialapp.retrofitTutorial.data.OneCoinData;

import java.util.List;

@Dao
public interface CoinsDatabaseInterface {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(OneCoinData oneCoinData);

    @Query("DELETE FROM my_coin_table")
    void deleteAll();

    @Query("SELECT * FROM my_coin_table ORDER BY exchange_id ASC")
    LiveData<List<OneCoinData>> getAlphabeticalOrderedCoinsLD();

    @Query("SELECT * FROM my_coin_table ORDER BY exchange_id ASC")
    List<OneCoinData> getListAlphabeticalOrderedCoins();
}
