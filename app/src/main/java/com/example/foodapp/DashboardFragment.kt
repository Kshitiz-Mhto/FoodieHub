package com.example.foodapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        getRequestWithParameters()
        return binding.root
    }

    private fun getRequestWithParameters(){
        val responseLiveData: LiveData<Response<FoodCategory>> = liveData {
            val response = retService.getCategory()
            emit(response)
        }
        val text_view = binding.dashText
        Log.i("MYTAG", text_view.toString())
        responseLiveData.observe(this, Observer {
            val foodList = it.body()?.categories?.listIterator()
            print(foodList)
//            Log.i("MYTAGS", foodList)
            if (foodList !=null) {
                while (foodList.hasNext()) {
                    val foodItem = foodList.next()
                    val result:String = " Album title: ${foodItem.idCategory} \n"+
                            " Album Id: ${foodItem.strCategory} \n"+
                            " User Id: ${foodItem.strCategoryDescription} \n\n\n"
                    text_view.append(result)
                }
            }
        })
    }


}