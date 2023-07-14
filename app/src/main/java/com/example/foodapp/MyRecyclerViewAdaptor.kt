package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.endpoints.CategoryService
import com.example.foodapp.modal.category.Category
import com.example.foodapp.modal.category.FoodCategory
import org.w3c.dom.Text
import retrofit2.Response

class MyRecyclerViewAdaptor(val catList: List<Category>) : RecyclerView.Adapter<MyViewHolder>() {
    var i = 0
    private lateinit var retService: CategoryService

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val listItem = layoutInflator.inflate(R.layout.list_cat, parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return catList.size-1
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.myTextView.text = catList.get(i).strCategory
        i++
    }
}

class MyViewHolder(val view:View): RecyclerView.ViewHolder(view){
    val myTextView = view.findViewById<TextView>(R.id.textView)
}



