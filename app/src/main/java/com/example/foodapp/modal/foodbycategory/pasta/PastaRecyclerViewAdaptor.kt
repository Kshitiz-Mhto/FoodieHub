package com.example.foodapp.modal.foodbycategory.pasta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R

class PastaRecyclerViewAdaptor(val pastaList: List<Meal>?) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val listItem = layoutInflator.inflate(R.layout.food_cardview, parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return pastaList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var index_element = pastaList!![position]
        Glide.with(holder.view.context)
            .load(index_element.strMealThumb)
            .into(holder.myImageView)
        holder.myTextView.text = index_element.strMeal
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val myTextView = view.findViewById<TextView>(R.id.tvFood)
    val myImageView = view.findViewById<ImageView>(R.id.etImage)
}