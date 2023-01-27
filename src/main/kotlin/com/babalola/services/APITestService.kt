package com.babalola.services

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class APITestService {


    @Value("\${spring.message}")
    lateinit var message: String

    fun apiTestStatus(status: String) = "Course management API $status, $message"
}