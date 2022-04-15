package com.madji.youtubetutorialapp.retrofitTutorial;

import static com.madji.youtubetutorialapp.retrofitTutorial.GetRetroFit.getRetroFit;

import android.content.Context;

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

        Retrofit retrofit = getRetroFit("X-CoinAPI-Key", "3CCDC3B6-F709-4544-86F9-69888FB0C543");
        ApiService service = retrofit.create(ApiService.class);
        AfterController ac = new AfterController(service);

        ac.doRequest(new ApiCallback(){
            @Override
            public void onSuccess(List<NewCoinData> coinList){
                int counter = 1;
                for (NewCoinData ncd : coinList) {
                    System.out.println("new " + counter++ + " id: " + ncd.getExchange_id() + " name: " + ncd.getName());
                }
            }
        });
    }


    private void WriteDataToFile(Call<List<NewCoinData>> call, File newFile) {
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

