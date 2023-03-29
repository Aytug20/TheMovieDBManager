package com.example.moviescatalog.local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moviescatalog.local.FavoriteMovieDatabase
import com.example.moviescatalog.local.WatchListModel


class WatchListViewModel(application: Application) : AndroidViewModel(application) {

    var movieWatchListLiveData : MutableLiveData<List<WatchListModel>>


    init {
        movieWatchListLiveData = MutableLiveData()
    }

    fun getAllWatchMoviesObservers() : MutableLiveData<List<WatchListModel>>{
        getAllWatchMovies()
        return movieWatchListLiveData
    }

    fun getAllWatchMovies() {
        val movieDao = FavoriteMovieDatabase.getDatabase(getApplication<Application?>().applicationContext)?.movieDao()
        val list = movieDao?.getAllWatchListMovie()

        movieWatchListLiveData.postValue(list!!)
    }
    fun insertWatchMovieİnfo(watchListModel: WatchListModel){
        val movieDao = FavoriteMovieDatabase.getDatabase((getApplication())).movieDao()
        movieDao?.insertWatchListAll(watchListModel)
        getAllWatchMovies()
    }
    fun deleteWatchMovieİnfo(watchListModel: WatchListModel){
        val movieDao = FavoriteMovieDatabase.getDatabase((getApplication()))?.movieDao()
        movieDao?.deleteAllWatchListMovie(watchListModel)
        getAllWatchMovies()
    }

}