package com.example.physicswallahassignment.models

data class ApiResponseItem(
    val id: Int,
    val name: String,
    val profileImage: String,
    val qualification: List<String>,
    val subjects: List<String>
)