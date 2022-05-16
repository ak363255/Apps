package com.example.apps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.network_module.NetworkUtility
import com.example.network_module.ResultEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         testapicall()
        setContent {
            Text(text = "Hello")
        }
    }

    fun testapicall(){
        CoroutineScope(Dispatchers.IO).launch {
            NetworkUtility.makeGetRequest<String>("https://www.google.com/", HashMap()).collect {
                 when(it){
                     is ResultEvent.OnFailure -> {
                         Log.d("API","onFailure "+it.msg)
                     }
                     ResultEvent.OnLoading -> {

                     }
                     is ResultEvent.OnSuccess -> {
                         Log.d("API","onSuccess "+it.data)
                     }
                 }
            }
        }
    }
}