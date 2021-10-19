package com.aldrek.alarmmanagerwhiledeviceisoff.util

import android.app.Activity
import android.app.AlarmManager
import android.app.AlarmManager.RTC_WAKEUP
import android.app.PendingIntent
import android.content.ActivityNotFoundException
import android.content.Context

import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import java.util.*


 fun AppCompatActivity.startAlarm(c: Calendar) {

    c.set(Calendar.SECOND , 0)
    val alarmManager =
        this.getSystemService(Context.ALARM_SERVICE) as? AlarmManager

    val intent = Intent(this, AlertReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)
    if (c.before(Calendar.getInstance())) {
        c.add(Calendar.DATE, 1)
    }
    alarmManager?.setExact(RTC_WAKEUP, c.timeInMillis, pendingIntent)
}

private const val HTTPS = "https://"
private const val HTTP = "http://"


fun Context.openWebPage(temp : String?) {

    var url = temp
    try {

        if (!url!!.startsWith(HTTP) && !url.startsWith(HTTPS)) {
            url = HTTP + url;
        }

        if (!URLUtil.isValidUrl(url)) {
            Toast.makeText(this, " invalid link", Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent)
        }
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(this, " You don't have any browser to open web page", Toast.LENGTH_LONG)
            .show()
    }
}
