package com.example.blog.service

import com.example.blog.service.dto.UsersAndArticlesDto


interface RetrieveDataService {
    fun retrieveAllUsersAndArticlesData(): UsersAndArticlesDto
}