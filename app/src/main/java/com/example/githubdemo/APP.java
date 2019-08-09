package com.example.githubdemo;

import android.app.Application;

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //  为了使app启动更快，需要把耗时在Application中初始化的三方放在IntentService中，这样避免启动需要等待很久
        // 处理app启动白屏或者黑屏需要设置启动页面的theme
        InitializationService.start(this);

    }
}
