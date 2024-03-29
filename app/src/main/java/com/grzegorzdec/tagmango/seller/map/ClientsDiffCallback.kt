package com.grzegorzdec.tagmango.seller.map

import com.grzegorzdec.tagmango.common.recyclerview.AbstractDiffCallback
import com.grzegorzdec.tagmango.model.Client

class ClientsDiffCallback : AbstractDiffCallback<Client>() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].isSelected == newItems[newItemPosition].isSelected && oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }
}