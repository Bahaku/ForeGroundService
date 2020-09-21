package com.example.fitnes.utils

import android.app.*
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.fitnes.R

object NotificationUtils {

        private const val CHANNEL_ID = "my_chanel"
        private const val CHANNEL_NAME = "CHANNEL_NAME"
        private const val CHANNEL_DESC = "CHANNEL_DESC"

        fun createNotification(context: Context): Notification? {
            createNotificationChannel(context)

            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("My Notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            return builder.build()

        }

        private fun showNotification(builder: Notification, context: Context) {
            NotificationManagerCompat.from(context).notify(1, builder)
        }

        private fun createNotificationChannel(context: Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val importance = NotificationManager.IMPORTANCE_HIGH
                val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance)
                channel.description = CHANNEL_DESC

                val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
        }
}