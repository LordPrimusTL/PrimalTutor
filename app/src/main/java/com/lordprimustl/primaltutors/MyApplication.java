package com.lordprimustl.primaltutors;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by LordPrimusTL on 9/20/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());
        // Required initialization logic here!
    }
}
