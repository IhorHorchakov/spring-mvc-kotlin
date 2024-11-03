package com.example.blog.web

import com.example.blog.service.RetrieveDataService
import com.example.blog.service.dto.UsersAndArticlesDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.time.measureTimedValue

@RestController
@RequestMapping("/api/retrieve")
class RetrieveDataController @Autowired constructor(val retrieveDataService: RetrieveDataService) {

    @GetMapping("/users-articles-data")
    fun retrieveUsersAndArticles(): UsersAndArticlesDto {
        val (data, duration) = measureTimedValue { retrieveDataService.retrieveAllUsersAndArticlesData() }
        println("Time taken to retrieve users and articles: $duration ms")
        return data
    }
}