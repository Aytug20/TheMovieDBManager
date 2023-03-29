package com.example.moviescatalog.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable


@Entity(tableName = "favorite_movie")
@Parcelize
data class FavoriteMovieModel (
    val original_title : String,
    val poster_path : String,

): Serializable,Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id : Int=0
}



