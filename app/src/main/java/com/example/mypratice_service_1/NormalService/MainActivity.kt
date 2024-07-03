package com.example.mypratice_service_1.NormalService

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mypratice_service_1.databinding.ActivityMainBinding

//
//
//普通的service啟動
//
//

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            myIntent = Intent(this, MyService::class.java)
            startService(myIntent)
        }
    }

    override fun onStop() {
        super.onStop()
        stopService(myIntent)
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        stopService(myIntent)
//    }
}