package com.mab.befix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class ErrorActivity extends AppCompatActivity {

    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppModel.sharedInstance.isNetworkAvailable(ErrorActivity.this)){
                    Intent in = new Intent(ErrorActivity.this, WebActivity.class);
                    startActivity(in);
                }else{
                    new AlertDialog.Builder(ErrorActivity.this)
                    .setTitle("Alert!")
                    .setMessage("Please turn on internet to use this application")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
                }
            }
        });

    }
}