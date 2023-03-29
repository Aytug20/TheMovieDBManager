package com.example.moviescatalog.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [FavoriteMovieModel::class, WatchListModel::class], version = 1)
abstract class FavoriteMovieDatabase : RoomDatabase(){

    abstract fun movieDao() : FavoriteMovieDao?
    companion object{
        private var INSTANCE : FavoriteMovieDatabase? = null

        fun getDatabase(context: Context): FavoriteMovieDatabase{

            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    FavoriteMovieDatabase::class.java,
                    "movieDB"
                )
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE!!
        }
    }


}

/*

   companion object {

       @Volatile private var instance : FavoriteMovieDatabase? = null //Diğer threadlere görünür yapıyor (Volatile)

       private val lock = Any()

       operator fun invoke(context: Context) = instance ?: synchronized(lock){
           instance ?: databaseBuilder(context).also {
               instance = it
           }
       }




       private fun databaseBuilder(context: Context) = Room.databaseBuilder(
           context.applicationContext,
           FavoriteMovieDatabase::class.java,
           "moviedatabase"
       ).build()

   }

    */

/*
    companion object{
        private var INSTANCE : FavoriteMovieDatabase? = null

        fun getDatabase(context: Context): FavoriteMovieDatabase{

            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    FavoriteMovieDatabase::class.java,
                "movieDB"
                ).build()

            }
            return INSTANCE!!
        }
    }
 */