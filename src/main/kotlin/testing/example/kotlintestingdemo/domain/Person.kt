package testing.example.kotlintestingdemo.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

data class Person(
    val id: Long? = null,
    val name: String? = null,
    val surname: String? = null
)