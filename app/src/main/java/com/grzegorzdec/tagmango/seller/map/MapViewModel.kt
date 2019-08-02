package com.grzegorzdec.tagmango.seller.map

import androidx.databinding.Bindable
import com.google.android.gms.maps.GoogleMap
import com.grzegorzdec.tagmango.BR
import com.grzegorzdec.tagmango.common.recyclerview.ListBinder
import com.grzegorzdec.tagmango.common.replace
import com.grzegorzdec.tagmango.model.Client
import com.grzegorzdec.tagmango.repository.Repository
import com.grzegorzdec.tagmango.tools.RegistryViewModel
import kotlinx.coroutines.launch

class MapViewModel(
    private val repository: Repository
) : RegistryViewModel() {

    @get:Bindable
    var clients: List<Client> = emptyList()
        set(value) {
            field = value
            listBinder.notifyDataChange(value)
            registry.notifyChange(this@MapViewModel, BR.clients)
        }

    @get:Bindable
    var selectedClient: Client? = null
        set(value) {
            value?.let {
                if (field == value) {
                    clients = clients
                        .replace(value?.copy(isSelected = false)!!) {
                            value.id == it.id
                        }
                    field = null
                } else {
                    clients = clients
                        .map { it.copy(isSelected = false) }
                        .replace(value?.copy(isSelected = true)!!) {
                            value.id == it.id
                        }
                    field = value.copy(isSelected = true)
                }
                registry.notifyChange(this@MapViewModel, BR.selectedClient)
            }
        }

    @get:Bindable
    val listBinder: ListBinder<Client> = ListBinder(ClientsDiffCallback())

    val onClientClickListener = GoogleMap.OnMarkerClickListener { marker ->
        selectedClient = clients.find { it.name == marker.title }
        true
    }

    fun loadClients() {
        scope.launch {
            repository.getAllClients().apply {
                clients = this ?: emptyList()
            }
        }
    }
}