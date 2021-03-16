package com.example.Food_API.controller

import com.example.Food_API.service.FoodService
import org.springframework.web.bind.annotation.*

const val RAPID_API_KEY = "a39f11b907mshceff79aff7b84ebp1c6c4cjsn52c1abade2c3"
const val RAPID_API_HOST = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com"
const val RAPID_API_URL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/"

@RestController
@RequestMapping("/api/recipes")
class RecipeController(private val service: FoodService) {

    @GetMapping("/{recipeId}/ingredients", produces = ["application/json"])
    fun findIngredientsByRecipeId(@PathVariable recipeId: Int): String? {
        return service.getIngredientsByRecipeId(recipeId)
    }

    @GetMapping(produces = ["application/json"])
    fun findRecipes(@RequestParam("food_query", required = true) foodQuery: String): String? {
        return service.getRecipes(foodQuery)
    }
}