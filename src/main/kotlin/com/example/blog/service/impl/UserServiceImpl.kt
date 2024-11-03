package com.example.blog.service.impl

import com.example.blog.repo.UserRepository
import com.example.blog.service.UserService
import com.example.blog.service.converter.UserConverter
import com.example.blog.service.dto.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    val userRepository: UserRepository,
    val userConverter: UserConverter
) : UserService {

    @Throws(IllegalArgumentException::class)
    override fun findByLogin(login: String): UserDto {
        val userEntity = userRepository.findByLogin(login)
            ?: throw IllegalArgumentException("No user found")
        return userConverter.toUserDto(userEntity)
    }

    override fun findAll(): Iterable<UserDto> {
        val iterable = userRepository.findAll()
        return userConverter.toIterableUserDto(iterable)
    }
}