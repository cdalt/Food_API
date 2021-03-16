package com.example.Food_API.service

import com.example.Food_API.controller.RAPID_API_HOST
import com.example.Food_API.controller.RAPID_API_KEY
import com.example.Food_API.controller.RAPID_API_URL
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service

const val RAPID_API_KEY = "a39f11b907mshceff79aff7b84ebp1c6c4cjsn52c1abade2c3"
const val RAPID_API_HOST = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com"
const val RAPID_API_URL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/"


@Service

class DefaultFoodService: FoodService {
override fun getIngredientsByRecipeId (foodId: Int): String? {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("$RAPID_API_URL$foodId/information")
        .get()
        .addHeader("x-rapidapi-key", RAPID_API_KEY)
        .addHeader("x-rapidapi-host", RAPID_API_HOST)
        .build()

    val response = client.newCall(request).execute()
    return response.body()?.string()
}
    override fun getRecipes (foodQuery: String): String? {
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