package com.example.moviescatalog.local

import android.inputmethodservice.Keyboard
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescatalog.R
import com.example.moviescatalog.adapter.RecyclerViewAdapter
import com.example.moviescatalog.databinding.FavoriteItemBinding
import com.example.moviescatalog.databinding.FragmentFavoritesBinding
import com.example.moviescatalog.databinding.RowLayoutBinding
import com.example.moviescatalog.imageLoad
import com.example.moviescatalog.model.MovieModel

class FavoritesRecyclerViewAdapter : RecyclerView.Adapter<FavoritesRecyclerViewAdapter.MyViewHolder>() {

    private lateinit var list: List<FavoriteMovieModel>


    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setMovieList(list: List<FavoriteMovieModel>){
        this.list = list
        notifyDataSetChanged()

    }

    var items = ArrayList<FavoriteMovieModel>()
    interface OnItemClickCallback {
        fun onDeleteClick(favoriteMovieModel: FavoriteMovieModel)
        fun onItemClick(favoriteMovieModel: FavoriteMovieModel)
    }


    inner class MyViewHolder(var binding: FavoriteItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(favoriteMovieModel: FavoriteMovieModel) {
            binding.txtTitle.text = favoriteMovieModel.original_title
            binding.imgFavorite.imageLoad(favoriteMovieModel.poster_path)

            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClick(favoriteMovieModel)
            }


            binding.toggleDelete.setOnClickListener {

                onItemClickCallback?.onDeleteClick(favoriteMovieModel)


            }
        }





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = FavoriteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoritesRecyclerViewAdapter.MyViewHolder, position: Int ) {
        holder.bind(list[position])

    }
    override fun getItemCount(): Int {
        return list.size
    }


}