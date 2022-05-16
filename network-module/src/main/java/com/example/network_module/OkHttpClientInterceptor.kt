package com.example.network_module

import okhttp3.Interceptor
import okhttp3.Response

class OkHttpClientInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .addHeader("cache-control","no chache")
        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }
}