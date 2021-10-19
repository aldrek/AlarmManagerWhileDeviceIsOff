package com.aldrek.alarmmanagerwhiledeviceisoff.util.extention

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldrek.alarmmanagerwhiledeviceisoff.adapter.common.CommonRecyclerAdapter


inline fun <reified T> RecyclerView.define(rvAdapter: CommonRecyclerAdapter<T>, type: Int = RecyclerView.VERTICAL) {
    apply {
        layoutManager = LinearLayoutManager(context, if (type == 0) RecyclerView.HORIZONTAL else RecyclerView.VERTICAL, false)
        isNestedScrollingEnabled = false
        adapter = rvAdapter
    }
}



inline fun <reified T> RecyclerView.defineStacked(rvAdapter: CommonRecyclerAdapter<T>, type: Int) {
    apply {

        var manager = LinearLayoutManager(context, if (type == 0) RecyclerView.HORIZONTAL else RecyclerView.VERTICAL, false)
        manager.stackFromEnd = true
        layoutManager = manager
        isNestedScrollingEnabled = false
        adapter = rvAdapter

    }
}

inline fun RecyclerView.splitContentEquality(rowNU: Int) {
    layoutManager = object : LinearLayoutManager(context, HORIZONTAL, false) {
        override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
            // force height of viewHolder here, this will override layout_height from xml
            lp.width = width / rowNU
            return true
        }
    }
}


inline fun <reified T> RecyclerView.defineGrid(rvAdapter: CommonRecyclerAdapter<T>) {
    apply {
        layoutManager = GridLayoutManager(context, 3)
        isNestedScrollingEnabled = false
        adapter = rvAdapter
    }
}
