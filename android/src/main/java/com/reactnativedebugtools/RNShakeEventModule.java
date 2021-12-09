package com.reactnativedebugtools;

import androidx.annotation.Nullable;

import android.content.Context;
import android.hardware.SensorManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.module.annotations.ReactModule;

public class RNShakeEventModule extends ReactContextBaseJavaModule {
    @Nullable
    private CustomShakeDetector mShakeDetector = null;
    @Nullable
    private final ReactApplicationContext reactContext;

    public RNShakeEventModule(@Nullable ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public void initialize() {
//        assert reactContext != null;
//        mShakeDetector = new CustomShakeDetector(new CustomShakeDetector.ShakeListener() {
//            @Override
//            public void onShake() {
//                sendEvent(reactContext, "ShakeEvent", null);
//            }
//        });
//
//        mShakeDetector.start(
//                (SensorManager) reactContext.getSystemService(Context.SENSOR_SERVICE));
    }

    @Override
    public String getName() {
        return "RNShakeEvent";
    }

    private void sendEvent(
            ReactContext reactContext,
            String eventName,
            @Nullable WritableMap params
    ) {
        if (reactContext.hasActiveCatalystInstance()) {
            reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
        }
    }
}
