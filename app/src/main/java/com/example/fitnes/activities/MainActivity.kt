package com.example.fitnes.activities

import android.content.Intent
import android.os.Bundle
import com.example.fitnes.MyLocationForegroundService
import com.example.fitnes.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseMainActivity() {
    override fun getResId() = R.layout.activity_main
    override fun getMapViewId() = R.id.mapView

    private val intentService by lazy {
        val intent = Intent(this, MyLocationForegroundService::class.java)
        intent.putExtra("test", "MyIntent")
    intent}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListeners()
    }

   private fun setupListeners(){
       start.setOnClickListener{startForegroundService()}

       stop.setOnClickListener{destroyService()}

       description.setOnClickListener{startActivity()}

   }

    private fun startForegroundService(){
        startService(intentService)
    }

    private fun startActivity(){
        val int = Intent(this, OnBoardingActivity::class.java)
        startActivity(int)
    }

    private fun destroyService(){
        stopService(intentService)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(intentService)
    }



}