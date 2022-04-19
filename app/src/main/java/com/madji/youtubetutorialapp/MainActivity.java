package com.madji.youtubetutorialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.test.core.app.ApplicationProvider;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.madji.youtubetutorialapp.retrofitTutorial.controllers.Controller;
import com.madji.youtubetutorialapp.retrofitTutorial.data.OneCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.database.CoinRepository;
import com.madji.youtubetutorialapp.retrofitTutorial.database.CoinsAppDatabase;
import com.madji.youtubetutorialapp.retrofitTutorial.views.OneCoinViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView temp;
    private Button loadDB;
    CoinsAppDatabase cd;
    CoinRepository cr;
    OneCoinViewModel oneCoinViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_coin_view);
        oneCoinViewModel = new ViewModelProvider(this).get(OneCoinViewModel.class);

        LiveData<List<OneCoinData>> allCoinsData = oneCoinViewModel.getAllCoinsData();

    }

    private View.OnClickListener loadDataFromDB = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            LiveData<List<OneCoinData>> allCoinsData = oneCoinViewModel.getAllCoinsData();

//            for(OneCoinData ocd : allCoinsData ) {
//                System.out.println("----" + ocd.getNickName() + " " + ocd.getDataPurchased());
//            }
        }
    };
}
