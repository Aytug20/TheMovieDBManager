package com.example.moviescatalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescatalog.databinding.FragmentWatchListBinding
import com.example.moviescatalog.local.WatchListModel
import com.example.moviescatalog.local.WatchListRecyclerViewAdapter
import com.example.moviescatalog.model.MovieModel
import com.example.moviescatalog.local.WatchListViewModel

class WatchList : Fragment(),WatchListRecyclerViewAdapter.OnItemClickCallback {

    lateinit var binding: FragmentWatchListBinding
    private lateinit var watchListViewModel: WatchListViewModel
    private var movieModel: MovieModel? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWatchListBinding.inflate(layoutInflater)
        val view = binding.root


        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
        binding.watchlistrecyclerview.layoutManager = layoutManager

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentWatchListBinding.bind(view)
        watchListViewModel = ViewModelProvider(this).get(WatchListViewModel::class.java)
        val adapter = WatchListRecyclerViewAdapter()
        watchListViewModel.getAllWatchMoviesObservers().observe(viewLifecycleOwner){
            adapter.setWatchMovieList(it)
            binding.apply {
                watchlistrecyclerview.setHasFixedSize(true)
                watchlistrecyclerview.adapter = adapter
            }

        }
        adapter.setOnWatchItemClickCallBack(object : WatchListRecyclerViewAdapter.OnItemClickCallback{
            override fun onItemClick(watchListModel: WatchListModel) {
                val movie = WatchListModel(
                    movieModel!!.original_title,
                    movieModel!!.poster_path

                )


                val action = WatchListDirections.actionWatchListToMovieDetailFragment(movie)
                findNavController().navigate(action)










            }

            override fun onDeleteClick(watchListModel: WatchListModel) {
                watchListViewModel.deleteWatchMovieİnfo(watchListModel)
            }

        })

        //clickBackButton()


    }
    /*
    private fun clickBackButton(){
        binding.watchlistToolbar.customToolbar.setNavigationOnClickListener {
            val action = WatchListDirections.actionWatchListToMovieDetailFragment()
            findNavController().navigate(action)
        }
    }

     */



    override fun onItemClick(watchListModel: WatchListModel) {
        TODO("Not yet implemented")
    }

    override fun onDeleteClick(watchListModel: WatchListModel) {
        TODO("Not yet implemented")
    }


}