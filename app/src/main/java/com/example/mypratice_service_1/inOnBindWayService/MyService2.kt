package com.example.mypratice_service_1.inOnBindWayService

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

//
//
//以onBind的方式啟動service
//
//


class MyService2 : Service() {
    private val TAG = "myTag:" + MyService2::class.java.simpleName

        inner class LocalBinder : Binder() {
        val myTestService: MyService2
            get() = this@MyService2
    }

    private val mBinder = LocalBinder()

    fun msg() {
        Log.d(TAG, "msg()")
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.d(TAG, "onBind()")
        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind()")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }
}