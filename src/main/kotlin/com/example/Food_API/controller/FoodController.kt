package com.example.Food_API.controller

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.web.bind.annotation.*
import java.lang.ref.Cleaner.create


@RestController
@RequestMapping("/api/food")
class FoodController() {
    @GetMapping(produces = ["application/json"])
    fun getRecipes(): String? {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/479101/information")
            .get()
            .addHeader("x-rapidapi-key", "a39f11b907mshceff79aff7b84ebp1c6c4cjsn52c1abade2c3")
            .addHeader("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
    return response.body()?.string()
    }
//    @PostMapping(consumes = ["application/json"])
//    fun save(@RequestBody ingredientList: String): String {
//        val client = OkHttpClient()
//
//        val mediaType = MediaType.parse("application/x-www-form-urlencoded")
//        val body = RequestBody.create(mediaType, "ingredientList=3%20oz%20pork%20shoulder&title=Pork%20roast%20with%20green%20beans")
//        val request = Request.Builder()
//            .url("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/cuisine")
//            .post(body)
//            .addHeader("content-type", "application/x-www-form-urlencoded")
//            .addHeader("x-rapidapi-key", "a39f11b907mshceff79aff7b84ebp1c6c4cjsn52c1abade2c3")
//            .addHeader("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
//            .build()
//
//        val response = client.newCall(request).execute()
//    }
}