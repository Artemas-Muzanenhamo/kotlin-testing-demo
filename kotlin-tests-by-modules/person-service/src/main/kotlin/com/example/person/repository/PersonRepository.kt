package com.example.person.repository

import com.example.person.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<PersonEntity, Long> {
    fun findFirstByName(name: String): PersonEntity
}