package com.example.physicswallahassignment.application

import android.app.Application
import com.example.physicswallahassignment.api.MyApi
import com.example.physicswallahassignment.repository.UserRepository

class UserApplication : Application() {

    lateinit var userRepository: UserRepository
    override fun onCreate() {
        super.onCreate()
        val retrofitService = MyApi.getRetrofit()
        userRepository = UserRepository(retrofitService)
    }
}