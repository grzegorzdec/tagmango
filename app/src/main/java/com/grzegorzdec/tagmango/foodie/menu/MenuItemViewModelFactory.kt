package com.grzegorzdec.tagmango.foodie.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grzegorzdec.tagmango.repository.Repository

class MenuItemViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MealItemViewModel(repository) as T
}