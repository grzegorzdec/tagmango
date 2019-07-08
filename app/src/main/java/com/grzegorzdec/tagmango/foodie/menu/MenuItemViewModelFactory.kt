package com.grzegorzdec.tagmango.foodie.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grzegorzdec.tagmango.model.Meal

class MenuItemViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MealItemViewModel() as T
}