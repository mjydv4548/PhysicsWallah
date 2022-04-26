package com.example.physicswallahassignment.api

import com.example.physicswallahassignment.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyApi {

    fun getRetrofit(): RetrofitService {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitService::class.java)
    }
}