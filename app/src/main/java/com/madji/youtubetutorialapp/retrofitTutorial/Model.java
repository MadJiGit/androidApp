package com.madji.youtubetutorialapp.retrofitTutorial;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model<T> {

//    Retrofit retrofit = getRetroFit("X-CoinAPI-Key", "3CCDC3B6-F709-4544-86F9-69888FB0C543");
//    ApiService service = retrofit.create(ApiService.class);
    private ApiService service;
    private Call<T> call;

    public Model(ApiService service, Call<T> call) {
        this.service = service;
        this.call = (Call<T>) call;
    }

    public void doRequest(final ApiCallback callback) {

        call.enqueue((Callback<T>) new Callback<T>() {

            @Override
            public void onResponse(Call<T> call,
                                   Response<T> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}


