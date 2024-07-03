package com.example.mypratice_service_1.NormalService

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


//
//
//普通的service啟動
//
//


class MyService : Service() {
    private var TAG = "myTag" + MyService::class.java.simpleName
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand()")
        return START_STICKY
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }
}