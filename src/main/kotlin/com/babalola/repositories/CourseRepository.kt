package com.babalola.repositories

import com.babalola.domains.Courses
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Courses, Int> {

}