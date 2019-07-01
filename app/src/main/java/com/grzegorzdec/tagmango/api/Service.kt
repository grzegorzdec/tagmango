package com.grzegorzdec.tagmango.api

import com.grzegorzdec.tagmango.model.Meal
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("grzegorzdec/fakeapi/meals")
    fun getAllMeals(): Deferred<Response<List<Meal>>>
}