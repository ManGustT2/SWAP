package com.example.swap;

import android.app.Application;

import com.facebook.stetho.Stetho;


/**
 * Created by Администратор on 05.01.2017.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
