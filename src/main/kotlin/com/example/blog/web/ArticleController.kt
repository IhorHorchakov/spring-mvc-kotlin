package com.example.blog.web

import com.example.blog.service.ArticleService
import com.example.blog.service.dto.ArticleDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/article")
class ArticleController @Autowired constructor(val articleService: ArticleService) {

    @GetMapping("/")
    fun findAll(): Iterable<ArticleDto> {
        return articleService.findAll()
    }

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug: String): ArticleDto {
        return articleService.findBySlug(slug)
    }

}
