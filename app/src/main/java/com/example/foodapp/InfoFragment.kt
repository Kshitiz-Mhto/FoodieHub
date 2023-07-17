package com.example.foodapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.FragmentInfoBinding
import com.example.foodapp.endpoints.SearchByName
import com.example.foodapp.modal.RetrofitInstance
import com.example.foodapp.modal.foodbysearch.FoodBySearch
import okhttp3.internal.toImmutableList
import retrofit2.Response

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var retFoodBySearch: SearchByName
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var foodName: String
    private lateinit var foodUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        retFoodBySearch = RetrofitInstance.getRetrofitInstance()
            .create(SearchByName::class.java)

        // Retrieve data from SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        foodName = sharedPreferences.getString("foodName", "") ?: ""
        foodUrl = sharedPreferences.getString("foodUrl", "") ?: ""
//        Log.i("name", foodName)

        val responseLiveData: LiveData<Response<FoodBySearch>> = liveData {
            val response = retFoodBySearch.getFoodBySearch(foodName)
//            Log.i("response", response.toString())
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val foodList = it.body()?.meals?.toImmutableList()
            if (foodList != null) {
                binding.etFood.text = foodName
                binding.etDescriptionDetail.text = foodList[0].strInstructions
                Glide.with(this.context)
                    .load(foodUrl)
                    .into(binding.etImage)
            }
        })


        return binding.root
    }
}