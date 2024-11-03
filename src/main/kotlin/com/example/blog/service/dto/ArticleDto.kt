package com.example.blog.service.dto

import java.time.LocalDateTime

data class ArticleDto(
    var id: Long?,
    var title: String,
    var headline: String,
    var content: String,
    var authorId: Long?,
    var slug: String,
    var addedAt: LocalDateTime,
)