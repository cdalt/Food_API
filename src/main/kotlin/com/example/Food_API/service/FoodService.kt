package com.example.Food_API.service

interface FoodService {
    fun getIngredientsByRecipeId(recipeId: Int): String?
    fun getRecipes(foodQuery: String): String?
}