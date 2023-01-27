package com.babalola.controllers

import com.babalola.dtos.CourseDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
internal class CourseControllerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient


    @Test
    fun create() {
        val newCourseDto = CourseDTO(null, "Kotlin/SpringBoot", "Technology")

        val savedCourseDTO = webTestClient.post()
            .uri("api/v1/courses/")
            .bodyValue(newCourseDto)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue(savedCourseDTO!!.id != null)
    }

    @Test
    fun getCourseService() {
    }
}