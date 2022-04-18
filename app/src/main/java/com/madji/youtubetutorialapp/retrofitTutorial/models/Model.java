package com.madji.youtubetutorialapp.retrofitTutorial.models;

import androidx.annotation.NonNull;

import com.madji.youtubetutorialapp.retrofitTutorial.interfaces.ApiCallback;

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
                    callback.onSuccess(response.body());
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


