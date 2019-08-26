package com.grzegorzdec.tagmango.seller.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grzegorzdec.tagmango.repository.Repository

class MapFragmentViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = MapViewModel(repository) as T
}