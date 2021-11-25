package com.mab.befix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myTask();
            }
        }, 1500);
    }

    public void myTask(){
        if (AppModel.sharedInstance.isNetworkAvailable(this)) {
            Intent in = new Intent(MainActivity.this, WebActivity.class);
            startActivity(in);
        }else{
            Intent in = new Intent(MainActivity.this, ErrorActivity.class);
            startActivity(in);
        }
    }
}