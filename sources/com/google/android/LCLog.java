package com.google.android;

import android.util.Log;

public class LCLog {
    public static final String TAG = LCLog.class.getSimpleName();

    public static void debug(String message) {
        Log.d(TAG, message);
    }

    public static void error(String message, Throwable throwable) {
        Log.e(TAG, message, throwable);
    }
}
