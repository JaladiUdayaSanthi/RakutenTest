package com.app.demo.repository

import com.app.demo.data.ResponseList
import retrofit2.Call
import retrofit2.http.GET

interface ServiceAPI {

    @GET("repositories/")
    fun getServiceUrl(): Call<ResponseList>

}