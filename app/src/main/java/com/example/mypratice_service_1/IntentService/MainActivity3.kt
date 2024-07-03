package com.example.mypratice_service_1.IntentService

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypratice_service_1.R
import com.example.mypratice_service_1.databinding.ActivityMainBinding


//
//
//這裡示範IntentService
//
//

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val myIntent = Intent(this, MyIntentService::class.java)
            startService(myIntent)
        }
    }
}