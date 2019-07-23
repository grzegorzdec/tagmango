package com.grzegorzdec.tagmango.common.recyclerview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.grzegorzdec.tagmango.seller.map.ClientsRecyclerAdapter

@BindingAdapter("listBinder")
fun <E> bindItems(recyclerView: RecyclerView, listBinder: ListBinder<E>) {
        val adapter = recyclerView.adapter
        if(adapter != null) {
            listBinder.setOnDataChangeListener(object: ListBinder.OnDataChangeListener {
                override fun onChange(diffResult: DiffUtil.DiffResult) {
                    diffResult.dispatchUpdatesTo(adapter)
                }
            })
        }
}