package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.endpoints.CategoryService
import com.example.foodapp.modal.foodbycategory.starter.Meal

class MyRecyclerViewAdaptor(val starterList: List<Meal>) : RecyclerView.Adapter<MyViewHolder>() {
    private lateinit var retService: CategoryService

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val listItem = layoutInflator.inflate(R.layout.food_cardview, parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return starterList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var index_element = starterList[position]
        Glide.with(holder.view.context)
            .load(index_element.strMealThumb)
            .into(holder.myImageView)
        holder.myTextView.text = index_element.strMeal
    }
}

class MyViewHolder(val view:View): RecyclerView.ViewHolder(view){
    val myTextView = view.findViewById<TextView>(R.id.tvFood)
    val myImageView = view.findViewById<ImageView>(R.id.etImage)
}



