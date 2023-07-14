package com.example.foodapp.modal.foodbycategory.starter

import com.google.gson.annotations.SerializedName

data class Starter(
    @SerializedName("meals")
    val meals: List<Meal>
)