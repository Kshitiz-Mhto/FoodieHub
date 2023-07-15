package com.example.foodapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.FragmentDashboardBinding
import com.example.foodapp.endpoints.CategoryService
import com.example.foodapp.endpoints.FoodsByCategory
import com.example.foodapp.modal.RetrofitInstance
import com.example.foodapp.modal.foodbycategory.Dessert.Dessert
import com.example.foodapp.modal.foodbycategory.Dessert.DessertRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.Goat.Goat
import com.example.foodapp.modal.foodbycategory.Goat.GoatRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.Lamb.Lamb
import com.example.foodapp.modal.foodbycategory.Lamb.LambRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.Pork.Pork
import com.example.foodapp.modal.foodbycategory.Pork.PorkRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.beef.Beef
import com.example.foodapp.modal.foodbycategory.beef.BeefRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.breakfast.Breakfast
import com.example.foodapp.modal.foodbycategory.breakfast.BreakfastRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.chicken.Chicken
import com.example.foodapp.modal.foodbycategory.chicken.ChickenRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.miscellaneous.Miscellaneous
import com.example.foodapp.modal.foodbycategory.miscellaneous.MiscellaneousRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.pasta.Pasta
import com.example.foodapp.modal.foodbycategory.pasta.PastaRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.seafood.Seafood
import com.example.foodapp.modal.foodbycategory.seafood.SeafoodRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.sides.Side
import com.example.foodapp.modal.foodbycategory.sides.SidesRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.starter.Starter
import com.example.foodapp.modal.foodbycategory.starter.StarterRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.vegan.Vegan
import com.example.foodapp.modal.foodbycategory.vegan.VeganRecyclerViewAdaptor
import com.example.foodapp.modal.foodbycategory.vegetarian.Vegetarian
import com.example.foodapp.modal.foodbycategory.vegetarian.VegetarianRecyclerViewAdaptor
import okhttp3.internal.toImmutableList
import retrofit2.Response


class DashboardFragment : Fragment() {
    private lateinit var retService: CategoryService
    private lateinit var retfoodsByCategory: FoodsByCategory
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        retService = RetrofitInstance.getRetrofitInstance().create(CategoryService::class.java)
        retfoodsByCategory =
            RetrofitInstance.getRetrofitInstance().create(FoodsByCategory::class.java)
        binding = FragmentDashboardBinding.inflate(inflater, container, false)

        val recyclerView = binding.dashRecyclerview
        recyclerView.setBackgroundColor(Color.TRANSPARENT)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.root.postDelayed(Runnable {
                binding.catStarter.performClick()
            },
            100)

        binding.catStarter.setOnClickListener {
            val responseLiveData: LiveData<Response<Starter>> = liveData {
                val response = retfoodsByCategory.getStarter()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = StarterRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catBeef.setOnClickListener {
            val responseLiveData: LiveData<Response<Beef>> = liveData {
                val response = retfoodsByCategory.getBeef()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = BeefRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catBreakfast.setOnClickListener {
            val responseLiveData: LiveData<Response<Breakfast>> = liveData {
                val response = retfoodsByCategory.getBreakfast()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = BreakfastRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catChicken.setOnClickListener {
            val responseLiveData: LiveData<Response<Chicken>> = liveData {
                val response = retfoodsByCategory.getChicken()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = ChickenRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catDessert.setOnClickListener {
            val responseLiveData: LiveData<Response<Dessert>> = liveData {
                val response = retfoodsByCategory.getDessert()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = DessertRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catGoat.setOnClickListener {
            val responseLiveData: LiveData<Response<Goat>> = liveData {
                val response = retfoodsByCategory.getGoat()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = GoatRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catLamb.setOnClickListener {
            val responseLiveData: LiveData<Response<Lamb>> = liveData {
                val response = retfoodsByCategory.getLamb()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = LambRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catMiscellaneous.setOnClickListener {
            val responseLiveData: LiveData<Response<Miscellaneous>> = liveData {
                val response = retfoodsByCategory.getMiscellaneous()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = MiscellaneousRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catPasta.setOnClickListener {
            val responseLiveData: LiveData<Response<Pasta>> = liveData {
                val response = retfoodsByCategory.getPasta()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = PastaRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catPork.setOnClickListener {
            val responseLiveData: LiveData<Response<Pork>> = liveData {
                val response = retfoodsByCategory.getPork()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = PorkRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catSeafood.setOnClickListener {
            val responseLiveData: LiveData<Response<Seafood>> = liveData {
                val response = retfoodsByCategory.getSeafood()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = SeafoodRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catSide.setOnClickListener {
            val responseLiveData: LiveData<Response<Side>> = liveData {
                val response = retfoodsByCategory.getSide()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = SidesRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catVegan.setOnClickListener {
            val responseLiveData: LiveData<Response<Vegan>> = liveData {
                val response = retfoodsByCategory.getVegan()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = VeganRecyclerViewAdaptor(foodList)
                }
            })
        }
        binding.catVegetarian.setOnClickListener {
            val responseLiveData: LiveData<Response<Vegetarian>> = liveData {
                val response = retfoodsByCategory.getVegetarian()
                emit(response)
            }
            responseLiveData.observe(this, Observer {
                val foodList = it.body()?.meals?.toImmutableList()
                if (foodList != null) {
                    recyclerView.adapter = VegetarianRecyclerViewAdaptor(foodList)
                }
            })
        }

        return binding.root
    }
}


//    private fun getRequestWithParameters() {
//
//        val responseLiveData: LiveData<Response<FoodCategory>> = liveData {
//            val response = retService.getCategory()
//            emit(response)
//        }
//        responseLiveData.observe(this, Observer {
//            val foodList = it.body()?.categories?.listIterator()
//            if (foodList != null) {
////                foodList
//            }
//        })
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
//                    Glide.with(this)
//                        .load(food_category_thumb)
//                        .override(400, 350)
//                        .fitCenter()
//                        .fitCenter()
//                        .into(cat_view0)
//                }
//            }
//        })
//    }


//}