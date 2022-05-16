package com.example.network_module

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.math.log

class ApiHelper private constructor(){
     private val CONNECTION_TIMEOUT = 10L
     private val CONNECTION_READ_TIMEOUT = 15L
     private val CONNECTION_WRITE_TIMEOUT = 15L
    private fun provideRetrofit() = lazy {
        Retrofit.Builder()
            .addConverterFactory(StringConvertorFactory())
            .addConverterFactory(provideGsonConvertorFactory)
            .addCallAdapterFactory(CustomApiResponseModelAdapterFactory())
            .client(provideOkhttpClient)
         .baseUrl("https://www.google.com/")
         .build()
    }

  private val  provideGsonConvertorFactory by lazy {
      GsonConverterFactory.create()
  }
     private val provideOkhttpClient by lazy {
         val loggingInterceptor = HttpLoggingInterceptor()
         if(BuildConfig.DEBUG)
             loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
         val client = OkHttpClient.Builder()
             .addInterceptor(OkHttpClientInterceptor())
             .addInterceptor(loggingInterceptor)
             .connectTimeout(CONNECTION_TIMEOUT,TimeUnit.SECONDS)
             .readTimeout(CONNECTION_READ_TIMEOUT,TimeUnit.SECONDS)
             .writeTimeout(CONNECTION_WRITE_TIMEOUT,TimeUnit.SECONDS)
             .build()
         client
     }
    internal fun provideApis () = provideRetrofit().value.create(Api::class.java)
    companion object{
        val retrofit by lazy {
            ApiHelper().provideApis()
        }
    }

}