package com.example.blog.service.impl

import com.example.blog.repo.ArticleRepository
import com.example.blog.service.ArticleService
import com.example.blog.service.converter.ArticleConverter
import com.example.blog.service.dto.ArticleDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleServiceImpl @Autowired constructor(
    val articleRepository: ArticleRepository,
    val articleConverter: ArticleConverter
) : ArticleService {

    @Throws(IllegalArgumentException::class)
    override fun findBySlug(slug: String): ArticleDto {
        val articleEntity = articleRepository.findBySlug(slug)
            ?: throw IllegalArgumentException("No article found by the given slug: '${slug}'")
        return articleConverter.toArticleDto(articleEntity)
    }

    override fun findAll(): Iterable<ArticleDto> {
        val iterable = articleRepository.findAll()
        return articleConverter.toIterableArticleDto(iterable)
    }
}