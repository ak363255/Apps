package com.example.network_module

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Url

interface Api {
    @GET
    suspend fun makeGetRequest(@Url url: String,@HeaderMap map:HashMap<String,Any>): ApiResponseModel
}