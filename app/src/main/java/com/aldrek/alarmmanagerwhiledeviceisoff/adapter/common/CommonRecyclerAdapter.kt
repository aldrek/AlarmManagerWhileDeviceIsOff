package com.aldrek.alarmmanagerwhiledeviceisoff.adapter.common

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class CommonRecyclerAdapter<T>(private val viewHolderFactory: ((parent: ViewGroup) -> CommonViewHolder<T>)) : RecyclerView.Adapter<CommonViewHolder<T>>() {

    var items: MutableList<T?>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder<T> {
        return viewHolderFactory(parent)
    }

    override fun onBindViewHolder(holder: CommonViewHolder<T>, position: Int) {
        val item = items?.get(position)

        holder.bindItem(item , position , isLastPostion = position+1 == items?.size ,{
            notifyAdapter()
                                          } , {
            items!!.removeAt(position)
            notifyItemRemoved(position) }
        )

    }

    override fun getItemCount(): Int = items?.size ?: 0

    private fun notifyAdapter () {
       notifyDataSetChanged()
    }

    fun <T> RecyclerView.Adapter<*>.autoNotify(old: List<T>, new: List<T>, compare: (T, T) -> Boolean) {
        val diff =  DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return compare(old[oldItemPosition], new[newItemPosition])
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return old[oldItemPosition] == new[newItemPosition]
            }

            override fun getOldListSize() = old.size

            override fun getNewListSize() = new.size
        })

        diff.dispatchUpdatesTo(this)

    }

}