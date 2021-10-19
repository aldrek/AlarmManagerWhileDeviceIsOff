package com.aldrek.alarmmanagerwhiledeviceisoff.adapter.viewholder

import android.view.ViewGroup
import android.widget.TextView
import com.aldrek.alarmmanagerwhiledeviceisoff.R
import com.aldrek.alarmmanagerwhiledeviceisoff.adapter.common.CommonViewHolder
import com.google.android.material.checkbox.MaterialCheckBox
import java.text.SimpleDateFormat
import java.util.*

class AlarmViewholder(var parent: ViewGroup, private val onChangeOnAlarm: ((isAlarmAdd: Boolean , alarm: Date) -> Unit)? = null)
    : CommonViewHolder<Date>(parent, R.layout.time_row) {

    var tvDate: TextView = itemView.findViewById(R.id.textview)
    var cb: MaterialCheckBox = itemView.findViewById(R.id.cb)

    val outputDateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).apply {
        var timeZone = TimeZone.getTimeZone("UTC")
    }

    // this is the best feelings of all
    override fun bindItem(
        item: Date?,
        position: Int,
        isLastPosition: Boolean,
        notify : () -> Unit?,
        remove : () -> Unit?
    ) {

        tvDate.text =  outputDateFormat.format(item?.time)

        cb.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (onChangeOnAlarm != null) {
                onChangeOnAlarm!!(isChecked , item!!)
            }

        }

    }

    public var checkBoxChangeListener: () -> Unit = {}

    companion object{

    }


}