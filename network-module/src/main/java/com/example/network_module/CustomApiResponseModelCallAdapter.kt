package com.example.network_module

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

//CallAdapter<R,T>-->convert Call to response type R into T eg:- R-->Call<T>
class CustomApiResponseModelCallAdapter(private val returnType: Type):CallAdapter<ResponseBody,Call<ApiResponseModel>> {
    override fun responseType(): Type {
        return returnType
    }

    override fun adapt(call: Call<ResponseBody>): Call<ApiResponseModel> {
        return CustomApiResponseCall(call)
    }

}