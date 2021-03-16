package com.example.Food_API.models

import javax.persistence.Id

data class Food (
    @Id
    val id: Long = -1,
    val name: String = ""
)