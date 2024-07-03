package com.example.mypratice_service_1.inOnBindWayService

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mypratice_service_1.databinding.ActivityMainBinding


//
//
//以onBind的方式啟動service
//
//

class MainActivity2 : AppCompatActivity() {
    private val TAG = "myTag:" + MainActivity2::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private var myService2: MyService2? = null
    private var isBind: Boolean = false // 判斷是否綁定

    private val mServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d(TAG, "onServiceConnected()")
            myService2 = (service as MyService2.LocalBinder).myTestService
            isBind = true
        }
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "onServiceDisconnected()")
            isBind = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.btn1.setOnClickListener {
            click1()
        }
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, MyService2::class.java)
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
        Log.d(TAG, "bindService()")
    }

    override fun onStop() {
        super.onStop()
        unbindService(mServiceConnection)
        Log.d(TAG, "unbindService()")
        isBind = false
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(TAG, "onDestroy")
//        unbindService(mServiceConnection)
//        Log.d(TAG, "unbindService()")
//        isBind = false
//    }

    // 當 mBoo 有綁定且 myService2 != null，就執行 MyService2 的 Msg()
    fun click1() {
        if (isBind && myService2 != null) {
            myService2!!.msg()
        }
    }
}