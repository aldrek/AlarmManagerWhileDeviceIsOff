package com.aldrek.alarmmanagerwhiledeviceisoff.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aldrek.alarmmanagerwhiledeviceisoff.R
import com.aldrek.alarmmanagerwhiledeviceisoff.adapter.common.CommonRecyclerAdapter
import com.aldrek.alarmmanagerwhiledeviceisoff.adapter.viewholder.AlarmViewholder
import com.aldrek.alarmmanagerwhiledeviceisoff.databinding.ActivityMainBinding
import com.aldrek.alarmmanagerwhiledeviceisoff.util.extention.showPicker
import com.aldrek.alarmmanagerwhiledeviceisoff.util.extention.viewBinding
import com.aldrek.alarmmanagerwhiledeviceisoff.util.extention.define
import com.aldrek.alarmmanagerwhiledeviceisoff.util.startAlarm
import java.util.*

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    val timerAdapter = CommonRecyclerAdapter {
        AlarmViewholder(it) { isSet, alarmDate ->
            setOrDeleteAlarmDependingOnTheStatusAndID(alarmDate)
        }
    }

    private fun setOrDeleteAlarmDependingOnTheStatusAndID(alarmDate: Date) {

        // task is open browser and when we are in this system
        var time = Calendar.getInstance()
        time.time = alarmDate
        startAlarm(time)

    }

    var alarmList = mutableListOf<Date?>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        // start alarm and delete alarm depending on ID
        // choose the technology that you want to do

        binding.recyclerView.define(timerAdapter)
        binding.pickTimer.setOnClickListener {

            showPicker {
                Log.d("TAG", "onCreate: ")
                val text = it.time
                alarmList.add(text)
                timerAdapter.items = alarmList
            }

        }

    }

}