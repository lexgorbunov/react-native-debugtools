package com.reactnativedebugtools

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.reactnativedebugtools.CustomShakeDetector
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.WritableMap
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter

class RNShakeEventModule(
    private val reactContext: ReactApplicationContext?
) : ReactContextBaseJavaModule(reactContext) {

    private val mShakeDetector: CustomShakeDetector? = null
    override fun initialize() {
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

    override fun getName(): String = "RNShakeEventModule"

    private fun sendEvent(
        reactContext: ReactContext,
        eventName: String,
        params: WritableMap?
    ) {
        if (reactContext.hasActiveCatalystInstance()) {
            reactContext.getJSModule(RCTDeviceEventEmitter::class.java).emit(eventName, params)
        }
    }
}
