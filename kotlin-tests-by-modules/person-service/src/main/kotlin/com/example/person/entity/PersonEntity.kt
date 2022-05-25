package com.example.person.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person")
class PersonEntity(
    @Id
    @GeneratedValue
    val id: Long? = null,
    val name: String? = null,
    val surname: String? = null
)