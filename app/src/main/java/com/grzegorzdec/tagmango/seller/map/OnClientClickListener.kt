package com.grzegorzdec.tagmango.seller.map

import com.grzegorzdec.tagmango.model.Client

interface OnClientClickListener {

    fun onClientClick(client: Client?)
}