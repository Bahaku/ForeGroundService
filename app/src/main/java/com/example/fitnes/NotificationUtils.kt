package com.example.fitnes

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationUtils {

        private const val CHANNEL_ID = "my_chanel"
        private const val CHANNEL_NAME = "CHANNEL_NAME"
        private const val CHANNEL_DESC = "CHANNEL_DESC"

        fun createNotification(context: Context, title: String?, body: String?) {
            createNotificationChannel(context)

            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .build()
            showNotification(builder, context)

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