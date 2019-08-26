package com.grzegorzdec.tagmango.tools

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("app:data")
fun <T> RecyclerView._setRecyclerViewData(data: T) {
    if (adapter is BindableAdapter<*>) {
        @Suppress("UNCHECKED_CAST")
        (adapter as BindableAdapter<T>).setData(data)
        adapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("app:onRefreshListener")
fun SwipeRefreshLayout._setOnRefreshListener(listener: () -> Unit) {
    setOnRefreshListener {
        listener()
    }
}

@BindingAdapter("app:srcCompatResource")
internal fun AppCompatImageView._setImageResource(resourceId: Int) {
    setImageResource(resourceId)
}