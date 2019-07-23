package com.grzegorzdec.tagmango.common.recyclerview

import androidx.recyclerview.widget.DiffUtil


abstract class AbstractDiffCallback<E>: DiffUtil.Callback() {

    var newItems = listOf<E>()
    var oldItems = listOf<E>()

    fun setData(oldList: List<E>, newList: List<E>) {
        this.oldItems = oldList
        this.newItems = newList
    }

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }
}