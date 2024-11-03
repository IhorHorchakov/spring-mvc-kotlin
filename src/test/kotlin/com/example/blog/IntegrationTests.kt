package com.example.blog

import com.example.blog.service.dto.UsersAndArticlesDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

	@BeforeAll
	fun setup() {
		println(">> Setup")
	}

	@Test
	fun `Assert retrieve users and articles`() {
		println(">> retrieve users and articles")
		val dto = restTemplate.getForObject<UsersAndArticlesDto>("/api/retrieve/users-articles-data")
		assertThat(dto).isNotNull()
		assertThat(dto!!.users).isNotNull()
		assertThat(dto!!.articles).isNotNull()
		assertThat(dto.users).hasSize(1)
		assertThat(dto.articles).hasSize(2)
	}

	@AfterAll
	fun teardown() {
		println(">> Tear down")
	}

}