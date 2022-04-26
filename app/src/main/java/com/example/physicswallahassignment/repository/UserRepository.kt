package com.example.physicswallahassignment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.physicswallahassignment.api.RetrofitService
import com.example.physicswallahassignment.models.ApiResponse

class UserRepository(private val retrofitService: RetrofitService) {

    private val _users: MutableLiveData<ApiResponse> = MutableLiveData()
    val users: LiveData<ApiResponse> get() = _users

    suspend fun getUsers() {
        val result = retrofitService.getUsers()

        if (result.isSuccessful && result.body() != null) {
            _users.postValue(result.body())
        }
    }
}