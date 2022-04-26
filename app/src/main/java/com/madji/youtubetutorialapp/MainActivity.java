package com.madji.youtubetutorialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ApplicationProvider;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.madji.youtubetutorialapp.retrofitTutorial.controllers.Controller;
import com.madji.youtubetutorialapp.retrofitTutorial.data.OneCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.database.CoinRepository;
import com.madji.youtubetutorialapp.retrofitTutorial.database.CoinsAppDatabase;
import com.madji.youtubetutorialapp.retrofitTutorial.database.CoinsDatabaseInterface;
import com.madji.youtubetutorialapp.retrofitTutorial.views.CoinListAdapter;
import com.madji.youtubetutorialapp.retrofitTutorial.views.OneCoinViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    OneCoinViewModel oneCoinViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.coinsListItem);

        final CoinListAdapter adapter = new CoinListAdapter(new CoinListAdapter.CoinDiff());
        
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        oneCoinViewModel = new ViewModelProvider(this).get(OneCoinViewModel.class);

        oneCoinViewModel.getAllCoinsDataLD().observe(this, adapter::submitList);

        Controller ctrl = new Controller();
        ctrl.start();

    }
}
