package com.babalola.controllers

import com.babalola.services.APITestService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
internal class APITestControllerTest {

    var URI = "/api/v1/test/{status}"

    @Autowired
   lateinit var webTestClient: WebTestClient;

    @MockkBean
    lateinit var apiTestServiceMock: APITestService

    @Test
    fun returnAPITestStatus() {

        val status = "working"

        val result = webTestClient.get()
            .uri(URI, status)
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()

        Assertions.assertEquals("Course management API $status, Course management application api works perfectly, no profile has been set", result.responseBody)
    }

    @Test
    fun getApiTestService() {

        val status = "working"

        every { apiTestServiceMock.apiTestStatus(any()) } returns "Course management API $status, Course management application api works perfectly, no profile has been set"

        val result = webTestClient.get()
            .uri(URI, status)
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()

        Assertions.assertEquals("Course management API $status, Course management application api works perfectly, no profile has been set", result.responseBody)
    }
}