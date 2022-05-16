package com.example.network_module

sealed class ResultEvent<out D> {
    data class OnSuccess<T>(val data:T):ResultEvent<T>()
    data class OnFailure(val msg:String,val debugMsg:String):ResultEvent<Nothing>()
    object OnLoading:ResultEvent<Nothing>()
}