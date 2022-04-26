package com.example.physicswallahassignment.api

import com.example.physicswallahassignment.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("users")
    suspend fun getUsers(): Response<ApiResponse>
}