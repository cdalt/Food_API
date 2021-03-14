package com.example.Food_API.service

import com.example.Food_API.models.Food

interface FoodService {
    fun findFoodById(foodId: Long): Food?
}