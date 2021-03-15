package com.example.Food_API.controller

import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.web.bind.annotation.*

const val RAPID_API_KEY = "a39f11b907mshceff79aff7b84ebp1c6c4cjsn52c1abade2c3"
const val RAPID_API_HOST = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com"
const val RAPID_API_URL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/"

@RestController
@RequestMapping("/api/food")
class FoodController() {


    @GetMapping("/{foodId}")
    fun findFoodById(@PathVariable foodId: Int): String? {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("${RAPID_API_URL}$foodId/information")
            .get()
            .addHeader("x-rapidapi-key", RAPID_API_KEY)
            .addHeader("x-rapidapi-host", RAPID_API_HOST)
            .build()

        val response = client.newCall(request).execute()
        return response.body()?.string()
    }
    @GetMapping("/recipes/{foodQuery}", produces = ["application/json"])
    fun getRecipes(@PathVariable foodQuery: String ): String? {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("${RAPID_API_URL}search?query=${foodQuery}")
            .get()
            .addHeader("x-rapidapi-key", RAPID_API_KEY)
            .addHeader("x-rapidapi-host", RAPID_API_HOST)
            .build()

        val response = client.newCall(request).execute()
        return response.body()?.string()
    }
}