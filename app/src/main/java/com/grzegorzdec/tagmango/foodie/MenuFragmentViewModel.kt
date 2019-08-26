package com.grzegorzdec.tagmango.foodie

import androidx.databinding.Bindable
import com.grzegorzdec.tagmango.BR
import com.grzegorzdec.tagmango.BaseViewModel
import com.grzegorzdec.tagmango.model.Meal
import com.grzegorzdec.tagmango.repository.Repository
import com.grzegorzdec.tagmango.tools.databinding.bindable
import kotlinx.coroutines.launch

class MenuFragmentViewModel(private val repository: Repository) : BaseViewModel() {

    @get:Bindable
    var data: Pair<List<Meal>, List<String>> = Pair(emptyList(), emptyList())

    var meals: List<Meal> = emptyList()
        set(value) {
            field = value
            data = data.copy(first = value)
            notifyPropertyChanged(BR.data)
        }

    var likedMeals: List<String> = emptyList()
        set(value) {
            field = value
            data = data.copy(second = value)
            notifyPropertyChanged(BR.data)
        }

    @get:Bindable
    var loading by bindable(false)

    init {
        fetchMeals()
    }

    fun fetchMeals() {
        loading = true

        scope.launch {
            repository.fetchMeals().apply {
                this?.let {
                    repository.insetMeals(it)
                }
                loading = false
            }
        }
    }
}