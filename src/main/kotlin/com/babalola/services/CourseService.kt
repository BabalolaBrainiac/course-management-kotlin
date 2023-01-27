package com.babalola.services

import com.babalola.domains.Courses
import com.babalola.dtos.CourseDTO
import com.babalola.repositories.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service


@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object : KLogging()

    fun createCourse(courseDTO: CourseDTO): CourseDTO {
        var newCourse = courseDTO.let {
             Courses(null, it.name, it.category)
        }

        courseRepository.save(newCourse)

        logger.info("New course created $newCourse ")

        return newCourse.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }

}
