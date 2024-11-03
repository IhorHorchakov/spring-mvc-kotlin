package com.example.blog.service.dto

data class UsersAndArticlesDto (
    var users: Iterable<UserDto>,
    var articles: Iterable<ArticleDto>
)