package com.grzegorzdec.tagmango.tools

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:data")
fun <T> _setRecyclerViewData(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is BindableAdapter<*>) {
        @Suppress("UNCHECKED_CAST")
        (recyclerView.adapter as BindableAdapter<T>).setData(data)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
