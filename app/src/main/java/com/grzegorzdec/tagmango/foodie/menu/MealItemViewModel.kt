package com.grzegorzdec.tagmango.foodie.menu

import androidx.databinding.Bindable
import com.grzegorzdec.tagmango.BR
import com.grzegorzdec.tagmango.BaseViewModel
import com.grzegorzdec.tagmango.model.Meal

class MealItemViewModel : BaseViewModel() {

    @get:Bindable
    var meal: Meal? = null
        set(value) {
            field = value
            registry.notifyChange(this, BR.meal)
        }

    @get:Bindable("meal")
    val name
        get() = meal?.name

    @get:Bindable("meal")
    val price
        get() = meal?.price
}