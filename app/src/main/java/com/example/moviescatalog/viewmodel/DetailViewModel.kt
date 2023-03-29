package com.example.moviescatalog.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.moviescatalog.local.FavoriteMovieDatabase
import com.example.moviescatalog.local.FavoriteMovieModel

class DetailViewModel(application: Application) : AndroidViewModel(application) {


    var movieDetailLiveData : MutableLiveData<List<FavoriteMovieModel>>


    init {
        movieDetailLiveData = MutableLiveData()
    }

    fun getAllMoviesObservers() : MutableLiveData<List<FavoriteMovieModel>>{
        getAllMovies()
        return movieDetailLiveData
    }

    fun getAllMovies() {
        val movieDao = FavoriteMovieDatabase.getDatabase(getApplication<Application?>().applicationContext)?.movieDao()
        val list = movieDao?.getAllMovie()

        movieDetailLiveData.postValue(list!!)
    }
    fun insertMovieİnfo(favoriteMovieModel: FavoriteMovieModel){
        val movieDao = FavoriteMovieDatabase.getDatabase((getApplication())).movieDao()
        movieDao?.insertAll(favoriteMovieModel)
        getAllMovies()
    }
    fun deleteMovieİnfo(favoriteMovieModel: FavoriteMovieModel){
        val movieDao = FavoriteMovieDatabase.getDatabase((getApplication()))?.movieDao()
        movieDao?.deleteAllMovie(favoriteMovieModel)
        getAllMovies()
    }
    
    /*
    fun addToFavorite(movieModel: MovieModel) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addToFavorite(
                FavoriteMovieModel(
                    movieModel.original_title,
                    movieModel.poster_path
                )
            )
        }
    }

     */




    /*
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
                            movieDetailLiveData.postValue(it)
                            sqliteSakla(it)
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

     */

    /*

    private fun sqliteSakla(movieModels : List<MovieModel>){

        launch {
            val dao = FavoriteMovieDatabase(getApplication()).movieDao()
            dao.deleteAllMovie()
            val uuidList = dao.insertAll(*movieModels.toTypedArray())
            var i= 0
            while (i < movieModels.size){
                movieModels[i].uuid = uuidList[i].toInt()
                i = i+1
            }
            moviesGoster(movieModels)
        }}


  */
    /*
    fun verileriSQLitetanAl(){

        launch {

            val movieModels = FavoriteMovieDatabase(getApplication()).movieDao().getAllMovie()
            moviesGoster(movieModels)
            Toast.makeText(getApplication(),"Filmleri Room'dan Aldık",Toast.LENGTH_LONG).show()

        }

    }

     */

    private fun moviesGoster(movieModels: List<FavoriteMovieModel>){
        movieDetailLiveData.value = movieModels

    }

/*

    fun addToFavorite(movieModel: MovieModel) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addToFavorite(
                FavoriteMovieModel(
                    movieModel.id,
                    movieModel.original_title,
                    movieModel.poster_path
                )
            )
        }
        }


    suspend fun checkMovie(id: String) = repository.checkMovie(id)

    fun removeFromFavorite(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.removeFromFavorite(id)
        }
    }

     */
}















