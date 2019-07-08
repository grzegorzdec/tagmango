package com.grzegorzdec.tagmango.api

class Repository(private val api: Service) {
    suspend fun getAllMeals() =
        api.getAllMeals().await().body()
}