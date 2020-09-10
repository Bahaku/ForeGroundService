package com.example.fitnes

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity


object PermissionUtils {

    val locationPermission = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
    const val LOCATION_REQUEST_CODE = 101

   private fun checkPermission(activity: AppCompatActivity): Boolean{
        return activity.checkSelfPermission(locationPermission[0])==PackageManager.PERMISSION_GRANTED

    }

    fun requestLocationPermission(activity: AppCompatActivity):Boolean{
        if (checkPermission(activity))
            return true

        activity.requestPermissions(locationPermission, LOCATION_REQUEST_CODE)

        return false
    }
}

