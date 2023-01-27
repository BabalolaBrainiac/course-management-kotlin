package com.babalola.controllers

import com.babalola.services.APITestService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/test")
class APITestController(val apiTestService: APITestService) {
    companion object: KLogging();


    @GetMapping("/{status}")
    fun returnAPITestStatus(@PathVariable("status") status: String): String {

        logger.info("API Testing status is $status")
        return apiTestService.apiTestStatus(status)
    }
}