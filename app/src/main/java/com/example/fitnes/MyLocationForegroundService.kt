package com.example.fitnes

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.fitnes.utils.NotificationUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class  MyLocationForegroundService: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(1, NotificationUtils.createNotification(applicationContext))
        test()
        return START_REDELIVER_INTENT

    }

    private fun test() {
        GlobalScope.launch(Dispatchers.Default) {
            kotlin.run {
                for (i in 1..200) {
                    Log.d("test", i.toString())
                    delay(200)
                }
            }
        }

    }
}