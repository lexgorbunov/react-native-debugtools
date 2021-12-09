package com.example.reactnativedebugtools;

import android.widget.Toast;

import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity {

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        android.app.Activity x = this;
//        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(x, "Disabled", Toast.LENGTH_SHORT).show();
//            }
//        }, 3000);
    }



    @Override
    protected void onResume() {
        super.onResume();
//        getReactInstanceManager().getDevSupportManager().showDevOptionsDialog();
    }



    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "DebugtoolsExample";
    }
}
