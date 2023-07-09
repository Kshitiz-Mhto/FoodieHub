package com.example.foodapp

import com.example.foodapp.modal.category.FoodCategory
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {

    @GET("/api/json/v1/1/categories.php")
    abstract suspend fun getCategory(): Response<FoodCategory>

}