package com.babalola.domains

import jakarta.persistence.*


@Entity
@Table(name = "courses")
data class Courses(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long? = null,
    val name: String,
    val category: String,
)

