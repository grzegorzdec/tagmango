package com.grzegorzdec.tagmango.api

class Repository(private val api: Service) {
    suspend fun getAllMeals() =
        api.getAllMeals().await().body()

    suspend fun getAllClients() = api.getAllClients().await().body()
}