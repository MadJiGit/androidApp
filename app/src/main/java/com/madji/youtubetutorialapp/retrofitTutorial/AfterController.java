package com.madji.youtubetutorialapp.retrofitTutorial;

import static com.madji.youtubetutorialapp.retrofitTutorial.GetRetroFit.getRetroFit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AfterController {

//    Retrofit retrofit = getRetroFit("X-CoinAPI-Key", "3CCDC3B6-F709-4544-86F9-69888FB0C543");
//    ApiService service = retrofit.create(ApiService.class);
    private ApiService service;
    private Call<List<NewCoinData>> call;

    public AfterController(ApiService service) {
        this.service = service;
        this.call = service.loadAllCoinData();
    }


    public void doRequest(final ApiCallback callback) {

        call.enqueue(new Callback<List<NewCoinData>>() {

            @Override
            public void onResponse(Call<List<NewCoinData>> call,
                                   Response<List<NewCoinData>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<NewCoinData>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

//        @Override
//        public void onResponse(Call<List<NewCoinData>> call,
//                Response<List<NewCoinData>> response) {
//        }
//
//        @Override
//        public void onFailure(Call<List<NewCoinData>> call, Throwable t) {
//            t.printStackTrace();
//        }
}

/*
    public void doRequest(ApiService service) service{
        Call<List<NewCoinData>>  call = service.loadAllCoinData();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<NewCoinData>> call, Response<List<NewCoinData>> response) {
        if (response.isSuccessful()) {
            List<NewCoinData> coinList = response.body();
            int counter = 1;
            assert coinList != null;
            for (NewCoinData ncd : coinList) {
                System.out.println(counter++ + " id: " + ncd.getExchange_id() + " name: " + ncd.getName());
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<NewCoinData>> call, Throwable t) {
        t.printStackTrace();
    }
*/
