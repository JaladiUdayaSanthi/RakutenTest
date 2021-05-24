package com.app.demo.repository

import com.app.demo.data.ResponseList
import com.app.demo.model.Response
import retrofit2.await
import java.lang.Exception

class DetailsRepository constructor(private val serviceAPI: ServiceAPI) {

    suspend fun getListDetails(): Response<ResponseList> {
            return try {
                val result  = serviceAPI.getServiceUrl().await()
                return Response.Success(result)
            } catch (e: Exception) {
                Response.Error(e)
            }
    }
}