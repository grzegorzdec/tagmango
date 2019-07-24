package com.grzegorzdec.tagmango.foodie

import androidx.databinding.Bindable
import com.grzegorzdec.databinding.bindable
import com.grzegorzdec.tagmango.BaseViewModel
import com.grzegorzdec.tagmango.api.Repository
import com.grzegorzdec.tagmango.model.Meal
import kotlinx.coroutines.launch

class MenuFragmentViewModel(private val repository: Repository) : BaseViewModel() {

    @get:Bindable
    var meals: List<Meal> by bindable(emptyList())

    init {
        loadMeals()
    }

    private fun loadMeals() {
        scope.launch {
            repository.getAllMeals().apply {
                meals = this ?: emptyList()
            }
        }
    }
}