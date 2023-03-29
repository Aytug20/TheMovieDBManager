package com.example.moviescatalog.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescatalog.R
import com.example.moviescatalog.databinding.RowLayoutBinding
import com.example.moviescatalog.imageLoad
import com.example.moviescatalog.model.MovieModel
import com.example.moviescatalog.model.MovieResponse
import com.example.moviescatalog.view.MovieListFragmentDirections
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class RecyclerViewAdapter(private val movieList : ArrayList<MovieModel>,private val listener:Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    private val colors: Array<String> = arrayOf(
        "#1C1B1F",
        "#1C1B1F",
        "#1C1B1F",
        "#1C1B1F",
        "#1C1B1F",
        "#1C1B1F",
        "#1C1B1F",
        "#1C1B1F"
    )

    interface Listener {
        fun onItemClick(movieModel: MovieModel) {
            //02f4fb

        }
    }

    inner class RowHolder(var binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }


    override fun getItemCount(): Int {
        return movieList.count()

    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClick(movieList[position])
        }
        holder.binding.textName.text = movieList[position].title
        holder.binding.textDate.text = setDate(movieList[position].release_date)
        holder.binding.imageView.imageLoad(movieList[position].poster_path)
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
    }

    private fun setDate(date: String): String {
        if (!date.isNullOrEmpty()) {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            val dateF: Date = inputFormat.parse(date)!!
            return outputFormat.format(dateF)
        } else {
            return ""
        }
    }




    }









