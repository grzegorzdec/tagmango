package com.grzegorzdec.tagmango.foodie.menu

import androidx.databinding.Bindable
import com.grzegorzdec.tagmango.BaseViewModel
import com.grzegorzdec.tagmango.model.Meal
import com.midrive.databinding.bindable

class MealItemViewModel : BaseViewModel() {

    @get:Bindable
    var meal: Meal? by bindable(null)

    @get:Bindable("meal")
    val name
        get() = meal?.let { "${it.name} (${it.price}) " }

    @get:Bindable("meal")
    val description
        get() = meal?.description
}