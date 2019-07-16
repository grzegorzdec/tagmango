package com.grzegorzdec.tagmango.seller.map

import android.util.Log
import androidx.databinding.Bindable
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.grzegorzdec.tagmango.BR
import com.grzegorzdec.tagmango.BaseViewModel
import com.grzegorzdec.tagmango.api.Repository
import com.grzegorzdec.tagmango.model.Client
import kotlinx.coroutines.launch

class MapViewModel(
    private val repository: Repository
) : BaseViewModel() {

    @get:Bindable
    var clients: List<Client> = emptyList()

    @get:Bindable
    var selectedClient: Client? = null
        set(value) {
            if(field == value) field = null
            else field = value
            Log.d("SelectedClient", "${field?.name}")
            registry.notifyChange(this@MapViewModel, BR.client)
        }

    val onClientClickListener = GoogleMap.OnMarkerClickListener { marker ->
        selectedClient = clients.find { it.name == marker.title }
        false
    }

    fun loadClients() {
        scope.launch {
            repository.getAllClients().apply {
                clients = this ?: emptyList()
                registry.notifyChange(this@MapViewModel, BR.clients)
            }
        }
    }
}