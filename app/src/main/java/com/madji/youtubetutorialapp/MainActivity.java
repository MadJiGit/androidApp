package com.madji.youtubetutorialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces.ApiCallback;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces.ApiService;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces.models.Model;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api_data.AssetCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.api.coin.OneCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.api.constants.Credentials;
import com.madji.youtubetutorialapp.retrofitTutorial.api.coin.CoinsManager;
import com.madji.youtubetutorialapp.retrofitTutorial.api.controllers.Controller;
import com.madji.youtubetutorialapp.retrofitTutorial.local_storage.FileStorage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        CoinsManager allCoins = CoinsManager.getCoinsManager();
        ArrayList<OneCoinData> oneCoinExamplesList = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.coinsListItem);

        // This is logic for local storage



        OneCoinData coin1 = new OneCoinData("bitcoin", "BTC", "10", "21.04.2022", "10000");
        OneCoinData coin2 = new OneCoinData("etherum", "ETH", "100", "21.04.2022", "300");
        OneCoinData coin3 = new OneCoinData("luna", "LUNA", "1000", "21.04.2022", "80");

        oneCoinExamplesList.add(coin1);
        oneCoinExamplesList.add(coin2);
        oneCoinExamplesList.add(coin3);

        FileStorage.writeIntoFile(oneCoinExamplesList, this, Credentials.FILE_NAME);

        ArrayList<OneCoinData> result = FileStorage.readFromFile(this, Credentials.FILE_DIR, Credentials.FILE_NAME);

        for (OneCoinData oce : result) {
            System.out.println(" -- " + oce.getFullName());
        }




        /*
        //This is logic for DB
        final CoinListAdapter adapter = new CoinListAdapter(new CoinListAdapter.CoinDiff());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        oneCoinViewModel = new ViewModelProvider(this).get(OneCoinViewModel.class);

        oneCoinViewModel.getAllCoinsDataLD().observe(this, adapter::submitList);

        */
        

        Controller ctrl = new Controller();
        List<AssetCoinData> l;
        ctrl.getAssetCoinData((ApiCallback) this);


    }
}
