package com.grzegorzdec.tagmango.repository

import androidx.annotation.WorkerThread
import com.grzegorzdec.tagmango.model.Meal
import com.grzegorzdec.tagmango.repository.database.TagmangoDB

class Repository(private val api: Service, private val database: TagmangoDB) {


    suspend fun fetchMeals() = api.getAllMeals().await().body()

    @WorkerThread
    fun getAllMeals() = database.mealDao().getAllMeals()

    @WorkerThread
    fun insetMeals(meals: List<Meal>) {
        database.mealDao().insert(meals)
    }

}