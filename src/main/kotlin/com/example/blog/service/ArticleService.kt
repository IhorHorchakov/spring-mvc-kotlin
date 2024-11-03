package com.example.blog.service

import com.example.blog.service.dto.ArticleDto


interface ArticleService {
    fun findBySlug(slug: String): ArticleDto
    fun findAll(): Iterable<ArticleDto>
}