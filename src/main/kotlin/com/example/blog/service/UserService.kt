package com.example.blog.service

import com.example.blog.service.dto.UserDto


interface UserService {
    fun findByLogin(login: String): UserDto
    fun findAll(): Iterable<UserDto>
}