package com.example.blog.web

import com.example.blog.service.UserService
import com.example.blog.service.dto.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController @Autowired constructor(val userService: UserService) {

    @GetMapping("/")
    fun findAll(): Iterable<UserDto> {
        return userService.findAll()
    }

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String): UserDto {
        return userService.findByLogin(login)
    }
}
