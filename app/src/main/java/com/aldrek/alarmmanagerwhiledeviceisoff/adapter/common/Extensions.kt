package com.aldrek.alarmmanagerwhiledeviceisoff.adapter.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes resource: Int): View {
    return LayoutInflater.from(context).inflate(resource, this, false)
}

fun View.onClick(onClick: () -> Unit) {
    setOnClickListener { onClick() }
}

fun View.onClickWithResponse(onClick: (item : Any) -> Unit) {
    setOnClickListener { onClick(it) }
}