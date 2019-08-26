package com.grzegorzdec.tagmango.foodie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grzegorzdec.tagmango.repository.Repository

class MenuFragmentViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = MenuFragmentViewModel(repository) as T
}