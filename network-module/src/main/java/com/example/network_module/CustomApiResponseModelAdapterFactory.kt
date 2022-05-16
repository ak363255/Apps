package com.example.network_module

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class CustomApiResponseModelAdapterFactory:CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
         return CustomApiResponseModelCallAdapter(returnType)
    }
}