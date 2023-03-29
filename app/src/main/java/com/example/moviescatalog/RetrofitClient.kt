package com.example.moviescatalog

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviescatalog.local.FavoriteMovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


object RetrofitClient {

    private val BASE_URL = "https://api.themoviedb.org/3/"

    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}


