package com.example.foodapp.modal.foodbycategory.pasta

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R

class PastaRecyclerViewAdaptor(val pastaList: List<Meal>?, val context: Context) : RecyclerView.Adapter<MyViewHolder>() {

    private lateinit var sp: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val listItem = layoutInflator.inflate(R.layout.food_cardview, parent, false)
        sp = parent.context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
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
        holder.myBuyButton.setOnClickListener {
            val editor = sp.edit()
            editor.putString("foodName", index_element.strMeal)
            editor.putString("foodUrl", index_element.strMealThumb)
            editor.apply()
            it.findNavController().navigate(
                R.id.action_dashboardFragment_to_infoFragment
            )
        }
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val myTextView = view.findViewById<TextView>(R.id.tvFood)
    val myImageView = view.findViewById<ImageView>(R.id.etImage)
    val myBuyButton = view.findViewById<ImageButton>(R.id.btnBuy)
}