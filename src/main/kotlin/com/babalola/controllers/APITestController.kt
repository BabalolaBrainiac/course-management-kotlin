package com.babalola.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/test")
class APITestController {

    @GetMapping("/{status}")
    fun returnAPITestStatus(@PathVariable("status") status: String): String {
        return "Course management API Status is $status"
    }
}