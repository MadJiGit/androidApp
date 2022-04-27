package com.madji.youtubetutorialapp.retrofitTutorial.local_storage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.madji.youtubetutorialapp.MainActivity;
import com.madji.youtubetutorialapp.retrofitTutorial.api.coin.OneCoinData;


import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileStorage {

    public static ArrayList<OneCoinData> readFromFile(MainActivity mainActivity, String fileDir, String fileName) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mainActivity);
        Gson gson = new Gson();
        String json = prefs.getString(fileName, null);
        Type type = new TypeToken<ArrayList<OneCoinData>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public static void writeIntoFile(ArrayList<OneCoinData> oneCoinExamplesList, MainActivity mainActivity, String fileName) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mainActivity);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(oneCoinExamplesList);
        editor.putString(fileName, json);
        editor.apply();
    }
}
