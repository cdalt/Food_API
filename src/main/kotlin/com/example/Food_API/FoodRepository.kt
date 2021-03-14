package com.example.Food_API

import com.example.Food_API.models.Food
import org.springframework.data.repository.CrudRepository

interface FoodRepository: CrudRepository<Food, Long> {

}