package com.example.moviescatalog.local

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.moviescatalog.viewmodel.BaseViewModel
import kotlin.collections.ArrayList

class FavoriteViewModel(application: Application) : BaseViewModel(application) {

    var movieFavoriteLiveData = MutableLiveData<List<FavoriteMovieModel>>()
    private var movieModels: ArrayList<FavoriteMovieModel> = arrayListOf()

    init {
        movieFavoriteLiveData = MutableLiveData()
    }

    /*

    fun roomVerisiniAl(uuid: Int){

        launch {
            val dao =FavoriteMovieDatabase(getApplication()).movieDao()
            val movie = dao.getMovie(uuid)
            movieFavoriteLiveData.value = listOf(movie)
        }

    }

     */

}