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
    private final LiveData<List<OneCoinData>> allCoinsData;

    public OneCoinViewModel(@NonNull Application application) {
        super(application);
        coinRepository = new CoinRepository(application);
        allCoinsData = coinRepository.getAllCoinsData();
    }

    public LiveData<List<OneCoinData>> getAllCoinsData() {
        return this.allCoinsData;
    }

    public void insert (OneCoinData oneCoinData) {
        coinRepository.insert(oneCoinData);
    }
}

/*
public class WordViewModel extends AndroidViewModel {

   private WordRepository mRepository;

   private final LiveData<List<Word>> mAllWords;

   public WordViewModel (Application application) {
       super(application);
       mRepository = new WordRepository(application);
       mAllWords = mRepository.getAllWords();
   }

   LiveData<List<Word>> getAllWords() { return mAllWords; }

   public void insert(Word word) { mRepository.insert(word); }
}
 */