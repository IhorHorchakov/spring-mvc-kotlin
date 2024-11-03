package com.example.blog.service.converter

import com.example.blog.repo.entity.User
import com.example.blog.service.dto.UserDto
import org.springframework.stereotype.Component

@Component
class UserConverter {

    fun toUserDto(entity: User): UserDto {
        return UserDto(
            entity.id,
            entity.login,
            entity.firstname,
            entity.lastname,
            entity.description
        )
    }

    fun toIterableUserDto(iterable: Iterable<User>): Iterable<UserDto> {
        return iterable.map { user -> toUserDto(user) }
    }
}