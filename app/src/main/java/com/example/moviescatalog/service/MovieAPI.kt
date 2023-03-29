package com.example.moviescatalog.service

import com.example.moviescatalog.model.MovieResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("search/movie?api_key=be00c5443a064dc182fd6021eb753a57")

    fun getMovieList(
        @Query("query") query: String
    ): Call<MovieResponse>




}
