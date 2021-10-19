package com.aldrek.alarmmanagerwhiledeviceisoff.adapter.common

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class CommonViewBindingViewHolder<in Any>(parent: ViewGroup, layoutRes: Int, private val rootView: View)
    : RecyclerView.ViewHolder(rootView) {

    abstract fun bindItem(
        item: Any?,
        position: Int,
        notify : (() -> Unit?),
        delete : (() -> Unit?)
        )

}