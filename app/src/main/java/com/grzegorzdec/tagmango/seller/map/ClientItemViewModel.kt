package com.grzegorzdec.tagmango.seller.map

import androidx.databinding.Bindable
import com.grzegorzdec.tagmango.BR
import com.grzegorzdec.tagmango.model.Client
import com.grzegorzdec.tagmango.tools.RegistryViewModel

class ClientItemViewModel: RegistryViewModel() {

    @get:Bindable
    var client: Client? = null
        set(value) {
            field = value
            registry.notifyChange(this, BR.client)
        }

    @get:Bindable("client")
    val name
        get() = client?.name

    @get:Bindable("client")
    val latitude
        get() = client?.latitude

    @get:Bindable("client")
    val longitude
        get() = client?.longitude

    @get:Bindable("client")
    val isSelected: Boolean
            get() = client?.isSelected ?: false
}