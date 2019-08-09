package com.example.githubdemo;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

public class InitializationService extends IntentService {

    private static final String APP_LAUNCH = "app_launch";

    public InitializationService(String name) {
        super(name);
    }

    public static void start(Context context){
        Intent intent = new Intent(context,InitializationService.class);
        intent.setAction(APP_LAUNCH);
        context.startActivity(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent!=null){
            String action = intent.getAction();
            if (APP_LAUNCH.equals(action)){
                performInit();
            }
        }
    }

    private void performInit() {

    }
}
