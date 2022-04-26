package com.example.physicswallahassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.physicswallahassignment.repository.UserRepository
import kotlinx.coroutines.launch

class UsersViewModel(private val userRepository: UserRepository) : ViewModel() {

    val users = userRepository.users

    init {
        viewModelScope.launch {
            userRepository.getUsers()
        }

    }
}