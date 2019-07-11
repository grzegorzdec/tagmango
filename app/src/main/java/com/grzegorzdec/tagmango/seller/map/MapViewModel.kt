package com.grzegorzdec.tagmango.seller.map

import androidx.databinding.Bindable
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

    fun loadClients() {
        scope.launch {
            repository.getAllClients().apply {
                clients = this ?: emptyList()
                registry.notifyChange(this@MapViewModel, BR.clients)
            }
        }
    }
}