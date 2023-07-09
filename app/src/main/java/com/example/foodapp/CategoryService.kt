package com.example.foodapp

import com.example.foodapp.modal.category.FoodCategory
import retrofit2.Response
import retrofit2.http.GET

abstract class CategoryService {

    @GET("/categories.php")
    abstract suspend fun getCategory(): Response<FoodCategory>

}