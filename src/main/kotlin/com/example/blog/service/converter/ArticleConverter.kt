package com.example.blog.service.converter

import com.example.blog.repo.entity.Article
import com.example.blog.service.dto.ArticleDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ArticleConverter @Autowired constructor (val userConverter: UserConverter) {

    fun toArticleDto(entity: Article): ArticleDto {
        return ArticleDto(
            entity.id,
            entity.title,
            entity.headline,
            entity.content,
            entity.author.id,
            entity.slug,
            entity.addedAt
        )
    }

    fun toIterableArticleDto(iterable: Iterable<Article>): Iterable<ArticleDto> {
        return iterable.map { article -> toArticleDto(article) }
    }
}