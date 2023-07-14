package com.example.foodapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.foodapp.databinding.FragmentDashboardBinding
import com.example.foodapp.modal.RetrofitInstance
import com.example.foodapp.modal.category.FoodCategory
import retrofit2.Response
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.foodapp.modal.category.Category
import okhttp3.internal.toImmutableList


class DashboardFragment : Fragment() {
    private lateinit var retService: CategoryService
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        retService = RetrofitInstance.getRetrofitInstance().create(CategoryService::class.java)
        binding = FragmentDashboardBinding.inflate(inflater,container, false)

        val recyclerView = binding.dashCategory
//        recyclerView.setBackgroundColor(Color.TRANSPARENT)
//        getRequestWithParameters()
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        val responseLiveData: LiveData<Response<FoodCategory>> = liveData {
//            val response = retService.getCategory()
//            emit(response)
//        }
//        responseLiveData.observe(this, Observer {
//            val foodList = it.body()?.categories?.toImmutableList()
//            if (foodList != null) {
////                recyclerView.adapter = MyRecyclerViewAdaptor(foodList)
//
//            }
//        })

        return binding.root
    }

    private fun getRequestWithParameters() {

        val responseLiveData: LiveData<Response<FoodCategory>> = liveData {
            val response = retService.getCategory()
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val foodList = it.body()?.categories?.listIterator()
            if (foodList != null) {
//                foodList
            }
        })
//        return null

//        var cat_view0  = binding.catThumb0
//        var cat_title0 = binding.catTitle0
//        var i = 0
//        Log.i("MYTAG", cat_view.toString())
//        responseLiveData.observe(this, Observer {
//            val foodList = it.body()?.categories?.listIterator()
//            print(foodList)
////            Log.i("MYTAGS", foodList)
//            if (foodList !=null) {
////                var i = 0
//                while (foodList.hasNext()) {
////                for (i in 0 .. 1){
//                    val foodItem = foodList.next()
////                    val food_category_thumb = foodItem.strCategoryThumb
//
////                    cat_title0.text = foodItem.strCategory
////
////                }
//
//
////                    val result:String = " Album title: ${foodItem.idCategory} \n"+
////                            " Album Id: ${foodItem.strCategory} \n"+
////                            " User Id: ${foodItem.strCategoryDescription} \n\n\n"
//
////                    Log.i("url", food_category_thumb)
////                    text_view.append(result)
////                    Glide.with(this)
////                        .load(food_category_thumb)
////                        .override(400, 350)
////                        .fitCenter()
////                        .fitCenter()
////                        .into(cat_view0)
//                }
//            }
//        })
    }


}