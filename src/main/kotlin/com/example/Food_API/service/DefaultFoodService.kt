package com.example.Food_API.service

import com.example.Food_API.FoodRepository
import com.example.Food_API.models.Food
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class DefaultFoodService {
    @Autowired
    lateinit var repository: FoodRepository
    override fun findFoodById(foodId: Long): Food? {
        val repositoryFood = repository.findById(foodId)
        if (repositoryFood.isPresent){
            return repositoryFood.get()
        } else {
            throw Exception("Food not found")
        }
    }
}