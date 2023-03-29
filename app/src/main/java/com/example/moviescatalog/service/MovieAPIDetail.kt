package com.example.moviescatalog.service

import com.example.moviescatalog.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MovieAPIDetail {

    @GET("search/movie?api_key=be00c5443a064dc182fd6021eb753a57")

    fun getMovieDetail(
        @Query("uuid") uuid: Int
    ): Call<MovieResponse>
}