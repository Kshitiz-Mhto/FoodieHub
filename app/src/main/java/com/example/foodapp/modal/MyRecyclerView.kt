package com.example.foodapp.modal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.CategoryService
import com.example.foodapp.R
import com.example.foodapp.modal.category.FoodCategory
import retrofit2.Response
import com.example.foodapp.DashboardFragment

class MyRecyclerView:RecyclerView.Adapter<MyViewHolder>(), LifecycleOwner {
    private lateinit var retService: CategoryService

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return 14
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        retService = RetrofitInstance.getRetrofitInstance().create(CategoryService::class.java)
        val responseLiveData: LiveData<Response<FoodCategory>> = liveData {
            val response = retService.getCategory()
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val foodList = it.body()?.categories?.listIterator()
            print(foodList)
//            Log.i("MYTAGS", foodList)
            if (foodList !=null) {
                val foodItem = foodList.next()
                holder.catView.text =  foodItem.strCategory
            }
        })

    }

    override val lifecycle: Lifecycle
        get() = TODO("Not yet implemented")
}


class MyViewHolder(val view:View):RecyclerView.ViewHolder(view){

    val catView = view.findViewById<TextView>(R.id.tvCat)

}