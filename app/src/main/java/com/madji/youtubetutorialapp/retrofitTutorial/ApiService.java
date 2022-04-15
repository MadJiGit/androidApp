package com.madji.youtubetutorialapp.retrofitTutorial;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

//    @GET("exchanges?apikey=")
    @GET("exchanges?")
//    @GET("exchanges?apikey=3CCDC3B6-F709-4544-86F9-69888FB0C543")
    Call<List<NewCoinData>> loadAllCoinData();
}
