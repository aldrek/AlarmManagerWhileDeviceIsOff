package com.aldrek.alarmmanagerwhiledeviceisoff.util

import androidx.core.app.NotificationCompat

import android.content.Intent

import android.content.BroadcastReceiver
import android.content.Context
import android.util.Log

// open an alarm at certain time
class AlertReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("TAG", "onReceive: ")
        context?.openWebPage("www.google.com")
    }
}