package com.example.mvvmapplication.data.api

import com.example.mvvmapplication.data.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/everything")
    fun getRepo(@Query("q") keyword: String = "bitcoin"): Call<Data>
}