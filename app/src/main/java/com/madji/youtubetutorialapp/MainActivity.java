package com.madji.youtubetutorialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.madji.youtubetutorialapp.retrofitTutorial.Controller;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Controller controller = new Controller();
        controller.start();

    }
}
