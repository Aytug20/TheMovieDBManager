package com.example.moviescatalog.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "watchlist_movie")
data class WatchListModel (
    val original_title : String,
    val poster_path : String,
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id : Int=0
}
