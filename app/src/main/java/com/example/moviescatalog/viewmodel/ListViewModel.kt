package com.example.moviescatalog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviescatalog.RetrofitClient
import com.example.moviescatalog.model.MovieModel
import com.example.moviescatalog.model.MovieResponse
import com.example.moviescatalog.service.MovieAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel  : ViewModel() {

    var movieListLiveData = MutableLiveData<List<MovieModel>>()
    private var movieModels: ArrayList<MovieModel> = arrayListOf()

    init {
        movieListLiveData = MutableLiveData()
    }

    fun observeViewModel():MutableLiveData<List<MovieModel>> {
        return movieListLiveData
    }

    fun clearData(){
        return movieModels.clear()
    }

    fun loadData(query:String) {
        val retrofitInstance = RetrofitClient.getRetrofitInstance()
        val service = retrofitInstance.create(MovieAPI::class.java)
        val call = service.getMovieList(query)

        call.enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let{ it ->
                        movieModels = it.results
                        movieModels?.let{
                            movieListLiveData.postValue(it)
                            //recyclerViewAdapter = RecyclerViewAdapter(it,this@MovieListFragment)
                            //binding.recyclerView.adapter = recyclerViewAdapter
                        }
                    }
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })


    }

}


