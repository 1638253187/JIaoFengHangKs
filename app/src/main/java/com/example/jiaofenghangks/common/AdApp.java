package com.example.jiaofenghangks.common;

import android.app.Application;

public class AdApp  extends Application {
    public static  AdApp adApp;

    @Override
    public void onCreate() {
        super.onCreate();
        adApp=this;
    }

    public static AdApp getAdApp() {
        return adApp;
    }
}
