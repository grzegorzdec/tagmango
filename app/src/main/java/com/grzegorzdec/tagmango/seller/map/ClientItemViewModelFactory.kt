package com.grzegorzdec.tagmango.seller.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ClientItemViewModelFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>) = ClientItemViewModel() as T
}