package com.example.network_module

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

object NetworkUtility {

    const val NETWORK_FAILURE_MSG = "Something went wrong!! Please try after some time"
  suspend inline  fun<reified  T> makeGetRequest(url:String,header:HashMap<String,Any>):Flow<ResultEvent<T>> = flow{
      val data = ApiHelper.retrofit.makeGetRequest(url,header)
      emit(ResultEvent.OnLoading)
      if(data.status==1){
          if(String::class == T::class){
              emit(ResultEvent.OnSuccess(data.data as T))
              return@flow
          }
          val data = convertStringToDataClass<T>(data.data)
          if(data!=null){
              emit(ResultEvent.OnSuccess(data))
          }else{
              emit(ResultEvent.OnFailure(NETWORK_FAILURE_MSG,"Unable to parse data"))
          }
      }else{
          emit(ResultEvent.OnFailure(NETWORK_FAILURE_MSG, data.data))
      }
  }


     inline fun <reified T> convertStringToDataClass(data:String):T?{
        return try {
            gson.fromJson(data,T::class.java)
        }catch (e:Exception){
            return null
        }
    }
     val gson by lazy {
        Gson()
    }
}