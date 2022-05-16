package com.example.network_module

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

internal class StringConvertorFactory: Converter.Factory() {
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val converter = object :Converter<ResponseBody,String>{
            override fun convert(value: ResponseBody): String? {
                return value.string()
            }
        }
        return converter
    }

}