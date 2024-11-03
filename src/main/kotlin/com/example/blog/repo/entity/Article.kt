package com.example.blog.repo.entity

import com.example.blog.util.toSlug
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Article(
	var title: String,
	var headline: String,
	var content: String,
	@ManyToOne(fetch = FetchType.LAZY)
	var author: User,
	var slug: String = title.toSlug(),
	var addedAt: LocalDateTime = LocalDateTime.now(),
	@Id
	@GeneratedValue
	var id: Long? = null
)
