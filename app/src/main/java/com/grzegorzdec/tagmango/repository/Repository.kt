package com.grzegorzdec.tagmango.repository

import androidx.annotation.WorkerThread
import com.grzegorzdec.tagmango.model.LikedMeal
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

    @WorkerThread
    fun setLike(mealId: String, like: Boolean) {
        database.likedMealDao().setLike(LikedMeal(mealId, like))
    }

    @WorkerThread
    fun getLikes() = database.likedMealDao().getLikes()

    suspend fun getAllClients() = api.getAllClients().await().body()

    suspend fun getUser(id: String) = api.getUser(id).await().body()

}