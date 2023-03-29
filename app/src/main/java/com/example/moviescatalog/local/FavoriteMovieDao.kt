package com.example.moviescatalog.local

import androidx.room.*

@Dao
interface FavoriteMovieDao {




    @Insert
    fun insertAll(movieModel: FavoriteMovieModel?)

    @Insert
    fun insertWatchListAll(movieModel: WatchListModel?)

    @Query("SELECT * FROM favorite_movie ORDER BY id DESC")
    fun getAllMovie() : List<FavoriteMovieModel>?

    @Query("SELECT * FROM watchlist_movie ORDER BY id DESC")
    fun getAllWatchListMovie() : List<WatchListModel>?

    @Delete
    fun deleteAllMovie(movieModel: FavoriteMovieModel?)

    @Delete
    fun deleteAllWatchListMovie(movieModel: WatchListModel?)





    /*

    @Query("SELECT * FROM moviemodel WHERE uuid = :movieId")
    suspend fun getMovie(movieId : Int) : MovieModel

     */




    /*
    @Insert
    suspend fun addToFavorite(favoriteMovie: FavoriteMovieModel)

    @Query("SELECT * FROM favorite_movie" )
    fun getFavoriteMovie(): LiveData<List<FavoriteMovieModel>>

    @Query("SELECT count(*) FROM favorite_movie WHERE favorite_movie.id_movie = :id ")
    suspend fun checkMovie(id: String) : Int

    @Query("DELETE FROM favorite_movie WHERE favorite_movie.id_movie = :id")
    suspend fun removeFromFavorite(id: String): Int

     */




}