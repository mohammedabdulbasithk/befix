package com.mab.befix;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppModel {

    public static AppModel sharedInstance = new AppModel();

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ){
            return true;
        } else {
            return false;
        }
    }
}
