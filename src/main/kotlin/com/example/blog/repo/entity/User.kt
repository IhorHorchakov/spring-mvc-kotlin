package com.example.blog.repo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class User(
    @Id
    @GeneratedValue
    var id: Long?,
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String?
)
