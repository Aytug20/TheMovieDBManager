package com.example.moviescatalog.local

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescatalog.databinding.WatchlistItemBinding
import com.example.moviescatalog.imageLoad

class WatchListRecyclerViewAdapter : RecyclerView.Adapter<WatchListRecyclerViewAdapter.WatchlistViewHolder>() {

    private lateinit var watchList: List<WatchListModel>
    private var onItemClickCallback : OnItemClickCallback?=null

    fun setOnWatchItemClickCallBack(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setWatchMovieList(watchList: List<WatchListModel>){
        this.watchList = watchList
        notifyDataSetChanged()

    }

    inner class WatchlistViewHolder(var binding: WatchlistItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(watchListModel: WatchListModel){
            binding.watchlistTitle.text = watchListModel.original_title
            binding.imgWatchlist.imageLoad(watchListModel.poster_path)
            binding.watchlistDelete.setOnClickListener {

                onItemClickCallback?.onDeleteClick(watchListModel)
            }


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistViewHolder {
        val binding = WatchlistItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WatchlistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WatchlistViewHolder, position: Int) {
        holder.bind(watchList[position])
    }

    override fun getItemCount(): Int {
        return watchList.size
    }

    interface OnItemClickCallback{
        fun onItemClick(watchListModel: WatchListModel)
        fun onDeleteClick(watchListModel: WatchListModel)



    }
}