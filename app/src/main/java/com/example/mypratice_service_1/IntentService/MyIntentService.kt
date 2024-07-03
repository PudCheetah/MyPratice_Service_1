package com.example.mypratice_service_1.IntentService

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    private val TAG = "myTag" + MyIntentService::class.java.simpleName
    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent()")
        Thread.sleep(5000)
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }
}