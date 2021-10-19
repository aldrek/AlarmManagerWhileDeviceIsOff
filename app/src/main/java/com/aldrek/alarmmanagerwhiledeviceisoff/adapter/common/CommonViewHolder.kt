package com.aldrek.alarmmanagerwhiledeviceisoff.adapter.common

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class CommonViewHolder<in Any>(parent: ViewGroup, layoutRes: Int, val rootView: View = parent.inflate(layoutRes))
    : RecyclerView.ViewHolder(rootView) {

    abstract fun bindItem(
        item: Any?,
        position: Int,
        isLastPostion: Boolean,
        notify : (() -> Unit?),
        delete : (() -> Unit?)
        )

}