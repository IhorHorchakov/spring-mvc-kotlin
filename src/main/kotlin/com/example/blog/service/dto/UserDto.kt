package com.example.blog.service.dto

data class UserDto (
    var id: Long?,
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String?
)