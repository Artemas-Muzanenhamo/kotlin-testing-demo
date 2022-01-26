package testing.example.kotlintestingdemo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import testing.example.kotlintestingdemo.domain.Person
import testing.example.kotlintestingdemo.entity.PersonEntity

@Repository
interface PersonRepository: JpaRepository<PersonEntity, Long>