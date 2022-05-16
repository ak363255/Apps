package com.example.network_module

import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomApiResponseCall(private val call:Call<ResponseBody>):Call<ApiResponseModel> {
    override fun clone(): Call<ApiResponseModel>  = CustomApiResponseCall(call.clone())

    override fun execute(): Response<ApiResponseModel> {
         throw UnsupportedOperationException("execute not supported")
    }

    override fun enqueue(callback: Callback<ApiResponseModel>) {
        return call.enqueue(object:Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful && response.body()!=null){
                    callback.onResponse(this@CustomApiResponseCall,Response.success(ApiResponseModel(1,response.body().toString())))
                }else{
                    callback.onResponse(this@CustomApiResponseCall,Response.success(ApiResponseModel(0,"Response body is null "+response.message())))
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                callback.onResponse(this@CustomApiResponseCall, Response.success(ApiResponseModel(0,"error msg "+t.message)))
            }
        })
    }

    override fun isExecuted(): Boolean = call.isExecuted

    override fun cancel() =call.cancel()

    override fun isCanceled(): Boolean = call.isCanceled
    override fun request(): Request = call.request()

    override fun timeout(): Timeout = call.timeout()
}