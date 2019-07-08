package com.grzegorzdec.tagmango.foodie.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.grzegorzdec.tagmango.databinding.ItemMealBinding
import com.grzegorzdec.tagmango.model.Meal
import com.grzegorzdec.tagmango.tools.BindableAdapter

class MenuListAdapter(private val viewModelProvider: ViewModelProvider) :
    RecyclerView.Adapter<MenuListAdapter.ViewHolder>(),
    BindableAdapter<List<Meal>> {

    private var meals: List<Meal> = emptyList()

    override fun setData(data: List<Meal>) {
        meals = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = meals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            viewModel = viewModelProvider.get(meals[position].id, MealItemViewModel::class.java).apply {
                    meal = meals[position]
                }
        }
    }

    inner class ViewHolder(val binding: ItemMealBinding) : RecyclerView.ViewHolder(binding.root)
}