package com.grzegorzdec.tagmango.foodie

import androidx.databinding.Bindable
import com.grzegorzdec.tagmango.BaseViewModel
import com.grzegorzdec.tagmango.model.Meal
import com.grzegorzdec.tagmango.repository.Repository
import com.midrive.databinding.bindable
import kotlinx.coroutines.launch

class MenuFragmentViewModel(private val repository: Repository) : BaseViewModel() {

    @get:Bindable
    var meals: List<Meal> by bindable(emptyList())

    @get:Bindable
    var isLoading = false
        set(value) {
            field = value
            registry.notifyChange(this@MenuFragmentViewModel, BR.loading)
        }

    init {
        fetchMeals()
    }

    fun fetchMeals() {
        isLoading = true

        scope.launch {
            repository.fetchMeals().apply {
                this?.let {
                    repository.insetMeals(it)
                }
                isLoading = false
            }
        }
    }
}