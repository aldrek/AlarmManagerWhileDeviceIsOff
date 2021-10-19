package com.aldrek.alarmmanagerwhiledeviceisoff.util.extention

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener




class Picker {
}

fun AppCompatActivity.showPicker(onPositiveTap : (calender : Calendar)-> Unit){
    val picker =
        MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
            .setMinute(Calendar.getInstance().get(Calendar.MINUTE))
            .setTitleText("Select Appointment time")
            .build()
    picker.show(supportFragmentManager, "tag");

    picker.addOnPositiveButtonClickListener { view ->
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        val hour: Int = picker.hour
        val min: Int = picker.minute
        calendar.set(Calendar.HOUR_OF_DAY , hour)
        calendar.set(Calendar.MINUTE , min)
        onPositiveTap(calendar)
    }



}