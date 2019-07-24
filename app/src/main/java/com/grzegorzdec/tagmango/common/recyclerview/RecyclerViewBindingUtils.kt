package com.grzegorzdec.tagmango.common.recyclerview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.grzegorzdec.tagmango.seller.map.ClientsRecyclerAdapter

@BindingAdapter("listBinder")
fun <E> RecyclerView.bindItems(listBinder: ListBinder<E>) {
    this.adapter?.let {
        listBinder.setOnDataChangeListener(object : ListBinder.OnDataChangeListener {
            override fun onChange(diffResult: DiffUtil.DiffResult) {
                diffResult.dispatchUpdatesTo(it)
            }
        })
    }
}