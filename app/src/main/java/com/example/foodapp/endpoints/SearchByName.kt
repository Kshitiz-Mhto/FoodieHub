package com.example.foodapp.endpoints

import com.example.foodapp.modal.foodbysearch.FoodBySearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchByName {

    // url because query name should not be static in url.
    @GET("/api/json/v1/1/search.php")
    abstract suspend fun getFoodBySearch(@Query("s") food_name:String): Response<FoodBySearch>

}