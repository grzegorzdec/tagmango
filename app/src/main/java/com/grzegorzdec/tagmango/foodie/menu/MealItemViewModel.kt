package com.grzegorzdec.tagmango.foodie.menu

import androidx.annotation.UiThread
import androidx.databinding.Bindable
import com.grzegorzdec.tagmango.BaseViewModel
import com.grzegorzdec.tagmango.model.Meal
import com.grzegorzdec.tagmango.repository.Repository
import com.grzegorzdec.tagmango.tools.databinding.bindable
import kotlinx.coroutines.launch

class MealItemViewModel(private val repository: Repository) : BaseViewModel() {

    @get:Bindable
    var meal: Meal? by bindable(null)

    @get:Bindable("meal")
    val name
        get() = meal?.let { "${it.name} (${it.price}) " }

    @get:Bindable("meal")
    val description
        get() = meal?.description

    @get:Bindable
    var like = false
        set(value) {
            if (field != value) {
                field = value
                updateLike(value)
            }
        }

    @UiThread
    private fun updateLike(value: Boolean) {
        scope.launch {
            meal?.let {
                repository.setLike(it.id, value)
            }
        }
    }
}