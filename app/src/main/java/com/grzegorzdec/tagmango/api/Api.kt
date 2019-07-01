package com.grzegorzdec.tagmango.api

import com.grzegorzdec.tagmango.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class Api {
    companion object {

        @Volatile
        var INSTANCE: Service? = null

        fun getApi() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Retrofit.Builder()
                    .baseUrl(BuildConfig.API_ENDPOINT)
                    .client(getClient())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Service::class.java)
                    .also { INSTANCE = it }
            }


        fun clearInstance() {
            INSTANCE = null
        }

        private fun getClient() = OkHttpClient.Builder()
            .addInterceptor(getHttpLoggingInterceptor())
            .connectTimeout(21, TimeUnit.SECONDS)
            .readTimeout(21, TimeUnit.SECONDS)
            .build()

    }
}