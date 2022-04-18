package com.madji.youtubetutorialapp.retrofitTutorial.controllers;

import static com.madji.youtubetutorialapp.retrofitTutorial.controllers.GetRetroFit.getRetroFit;

import android.content.Context;

import com.madji.youtubetutorialapp.retrofitTutorial.constants.Credentials;
import com.madji.youtubetutorialapp.retrofitTutorial.interfaces.ApiService;
import com.madji.youtubetutorialapp.retrofitTutorial.data.AssetCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.data.ExchangeCoinData;
import com.madji.youtubetutorialapp.retrofitTutorial.models.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class Controller {

    public void start() {

        Retrofit retrofit = getRetroFit(Credentials.API_KEY, Credentials.API_KEY_VALUE);
        ApiService service = retrofit.create(ApiService.class);
        Model<List<AssetCoinData>> ac2 = new Model<>(service.loadCoinsAssetsData());
        Model<List<ExchangeCoinData>> ac1 = new Model<>(service.loadCoinsExchangeData());

        ac2.doRequest(result -> {
            List<AssetCoinData> ll =  (List<AssetCoinData>) result;
            int count = 0;
            for (AssetCoinData l : ll){
                if(l.isCrypto() && l.getPriceUSD() != null) {
                    count++;
                    String res = String.format("Coin name %s\t\tprice in $USD %f", l.getName(), l.getPriceUSD());
                    System.out.println(res.trim());
//                    System.out.println("Coin name " + l.getName() + "\t\t\tprice in $USD " + l.getPriceUSD());
                }
            }
            System.out.println("total coins data is: " + count);
            return ll;
        });

//        ac1.doRequest(result -> {
//            int count = 0;
//            List<ExchangeCoinData> ll =  (List<ExchangeCoinData>) result;
//            for (ExchangeCoinData l : ll){
//                System.out.println("----- " + l.getId());
//                if(count++ == 10){
//                    break;
//                }
//            }
//            return ll;
//        });

    }


    private void WriteDataToFile(Call<List<ExchangeCoinData>> call, File newFile) {
        try (FileOutputStream stream = new FileOutputStream(newFile)) {
            stream.write(call.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String ReadFromFile(Context context, String fileName) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(fileName);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            System.out.println("login activity" + "File not found: " + e.toString());
        } catch (IOException e) {
            System.out.println("login activity" + "Can not read file: " + e.toString());
        }

        System.out.println("read from file ------------------------- " + ret);

        return ret;
    }

}

/*

working callback
        ac1.doRequest(new ApiCallback() {
            @Override
            public void onSuccess(Object result) {
                int counter = 0;
                List<ExchangeCoinData> list =  (List<ExchangeCoinData>) result;
                for (ExchangeCoinData ncd : list) {
                    System.out.println("new " + counter++ + " exchange_id: " + ncd.getExchange_id() + " name: " + ncd.getName());
                }

            }
        });
 */
