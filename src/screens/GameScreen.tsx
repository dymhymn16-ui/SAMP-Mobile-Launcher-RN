package com.touch.mobile.dark.modules;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.touch.mobile.dark.MainGTA;

public class GtaSetupModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext context;

    public GtaSetupModule(ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext;
    }

    @ReactMethod
    public void startGame(Promise promise) {
        try {
            Activity activity = getCurrentActivity();

            if (activity == null) {
                promise.reject("NO_ACTIVITY", "لا توجد شاشة نشطة لتشغيل اللعبة");
                return;
            }

            Intent intent = new Intent(activity, MainGTA.class);

            Intent currentIntent = activity.getIntent();
            if (currentIntent != null && currentIntent.getExtras() != null) {
                intent.putExtras(currentIntent);
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

            activity.startActivity(intent);

            promise.resolve(true);

        } catch (Exception e) {
            promise.reject("START_GAME_ERROR", e.getMessage(), e);
        }
    }

    @NonNull
    @Override
    public String getName() {
        return "GtaSetupModule";
    }
  }
