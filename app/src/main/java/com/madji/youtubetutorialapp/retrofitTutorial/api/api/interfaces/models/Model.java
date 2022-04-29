package com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces.models;

import androidx.annotation.NonNull;

import com.madji.youtubetutorialapp.retrofitTutorial.api.api.interfaces.ApiCallback;
import com.madji.youtubetutorialapp.retrofitTutorial.api.api_data.AssetCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.api.coin.CoinsManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model<T> {

    private final Call<T> call;

    public Model(Call<T> call) {

        this.call = (Call<T>) call;
    }

    public void doRequest(final ApiCallback callback) {

        call.enqueue((Callback<T>) new Callback<T>() {

            @Override
            public void onResponse(@NonNull Call<T> call,
                                   @NonNull Response<T> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess((List<AssetCoinData>) response.body());
//                    CoinsManager.getCoinsManager().onSuccess((List<AssetCoinData>)response.body());
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }
}


