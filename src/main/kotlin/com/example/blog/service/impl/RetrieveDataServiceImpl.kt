package com.example.blog.service.impl

import com.example.blog.service.ArticleService
import com.example.blog.service.RetrieveDataService
import com.example.blog.service.UserService
import com.example.blog.service.dto.ArticleDto
import com.example.blog.service.dto.UserDto
import com.example.blog.service.dto.UsersAndArticlesDto
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.time.measureTimedValue

@Service
class RetrieveDataServiceImpl @Autowired constructor(
    val articleService: ArticleService,
    val userService: UserService
) : RetrieveDataService {

    // SCOPE: Use 'runBlocking' scope to ensure that the method can be called from a non-suspended nature
    // CONTEXT: Use 'async' to ensure the suspendable functions run on the Dispatchers.DEFAULT context suitable for long-running tasks.
    override fun retrieveAllUsersAndArticlesData(): UsersAndArticlesDto = runBlocking {
        val articlesDeferred = async { retrieveArticles() }
        val usersDeferred = async { retrieveUsers() }
        UsersAndArticlesDto(usersDeferred.await(), articlesDeferred.await())
    }

    private suspend fun retrieveArticles(): Iterable<ArticleDto> {
        val (articles, duration) = measureTimedValue { articleService.findAll() }
        println("Time taken to retrieve articles: $duration ms")
        return articles
    }

    private suspend fun retrieveUsers(): Iterable<UserDto> {
        val (users, duration) = measureTimedValue { userService.findAll() }
        println("Time taken to retrieve users: $duration ms")
        return users
    }

}
