package com.example.foodapp.endpoints

import com.example.foodapp.modal.foodbycategory.sides.Side
import com.example.foodapp.modal.foodbycategory.Dessert.Dessert
import com.example.foodapp.modal.foodbycategory.Goat.Goat
import com.example.foodapp.modal.foodbycategory.Lamb.Lamb
import com.example.foodapp.modal.foodbycategory.Pork.Pork
import com.example.foodapp.modal.foodbycategory.beef.Beef
import com.example.foodapp.modal.foodbycategory.breakfast.Breakfast
import com.example.foodapp.modal.foodbycategory.chicken.Chicken
import com.example.foodapp.modal.foodbycategory.miscellaneous.Miscellaneous
import com.example.foodapp.modal.foodbycategory.pasta.Pasta
import com.example.foodapp.modal.foodbycategory.seafood.Seafood
import com.example.foodapp.modal.foodbycategory.starter.Starter
import com.example.foodapp.modal.foodbycategory.vegan.Vegan
import com.example.foodapp.modal.foodbycategory.vegetarian.Vegetarian
import retrofit2.Response
import retrofit2.http.GET

interface FoodsByCategory {

    @GET("/api/json/v1/1/filter.php?c=Beef")
    abstract suspend fun getBeef(): Response<Beef>

    @GET("/api/json/v1/1/filter.php?c=Breakfast")
    abstract suspend fun getBreakfast(): Response<Breakfast>

    @GET("/api/json/v1/1/filter.php?c=Chicken")
    abstract suspend fun getChicken(): Response<Chicken>

    @GET("/api/json/v1/1/filter.php?c=Dessert")
    abstract suspend fun getDessert(): Response<Dessert>

    @GET("/api/json/v1/1/filter.php?c=Goat")
    abstract suspend fun getGoat(): Response<Goat>

    @GET("/api/json/v1/1/filter.php?c=Lamb")
    abstract suspend fun getLamb(): Response<Lamb>

    @GET("/api/json/v1/1/filter.php?c=Miscellaneous")
    abstract suspend fun getMiscellaneous(): Response<Miscellaneous>

    @GET("/api/json/v1/1/filter.php?c=Pasta")
    abstract suspend fun getPasta(): Response<Pasta>

    @GET("/api/json/v1/1/filter.php?c=Pork")
    abstract suspend fun getPork(): Response<Pork>

    @GET("/api/json/v1/1/filter.php?c=Seafood")
    abstract suspend fun getSeafood(): Response<Seafood>

    @GET("/api/json/v1/1/filter.php?c=Side")
    abstract suspend fun getSide(): Response<Side>

    @GET("/api/json/v1/1/filter.php?c=Starter")
    abstract suspend fun getStarter(): Response<Starter>

    @GET("/api/json/v1/1/filter.php?c=Vegan")
    abstract suspend fun getVegan(): Response<Vegan>

    @GET("/api/json/v1/1/filter.php?c=Vegetarian")
    abstract suspend fun getVegetarian(): Response<Vegetarian>
}