package com.grzegorzdec.tagmango.repository

import com.grzegorzdec.tagmango.model.Client
import com.grzegorzdec.tagmango.model.Meal
import com.grzegorzdec.tagmango.model.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("grzegorzdec/fakeapi/meals")
    fun getAllMeals(): Deferred<Response<List<Meal>>>

    @GET("grzegorzdec/fakeapi/clients")
    fun getAllClients(): Deferred<Response<List<Client>>>

    @GET("grzegorzdec/fakeapi/users/{user_id}")
    fun getUser(@Path(value = "user_id", encoded = true) userId: String): Deferred<Response<User>>
}