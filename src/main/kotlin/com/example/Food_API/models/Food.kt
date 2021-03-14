package com.example.Food_API.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "food")
data class Food {
    @Id
    val id: Long = -1
}