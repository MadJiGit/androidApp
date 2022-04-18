package com.madji.youtubetutorialapp.retrofitTutorial.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.madji.youtubetutorialapp.retrofitTutorial.constants.Credentials;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRetroFit {

    private static Gson getGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }


    static Retrofit getRetroFit(String key, String value){
        Gson gson = getGson();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader(key, value).build();
            return chain.proceed(request);
        });

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Credentials.BASE_URL)
                .client(httpClient.build())
                .build();
    }
}
