package com.grzegorzdec.tagmango.repository

import com.grzegorzdec.tagmango.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

internal fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    return loggingInterceptor
}