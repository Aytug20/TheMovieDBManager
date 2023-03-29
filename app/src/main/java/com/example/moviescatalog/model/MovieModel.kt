package com.example.moviescatalog.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

data class MovieModel (
    val adult : Boolean,
    @ColumnInfo(name = "poster_path")
    val poster_path : String,
    @ColumnInfo(name = "overview")
    val overview : String,
    @ColumnInfo(name = "release_date")
    val release_date : String,
    @ColumnInfo(name = "original_title")
    val original_title : String,

    @ColumnInfo(name = "id")
    val id : Int ,

    val media_type : String,

    val original_language : String,
    @ColumnInfo(name = "title")
    val title : String,

    val backdrop_path : String,

    val popularity : Double,

    val vote_count : Int,

    val video : Boolean,

    val vote_average : String

    )








