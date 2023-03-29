package com.example.moviescatalog

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.imageLoad(urlLast: String?){
    val url = "https://image.tmdb.org/t/p/w500"
    Glide.with(context).load(url+urlLast).into(this)
}


