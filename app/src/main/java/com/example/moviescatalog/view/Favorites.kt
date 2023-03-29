package com.example.moviescatalog.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescatalog.databinding.FragmentFavoritesBinding
import com.example.moviescatalog.local.FavoriteMovieDatabase
import com.example.moviescatalog.local.FavoriteMovieModel
import com.example.moviescatalog.local.FavoritesRecyclerViewAdapter
import com.example.moviescatalog.model.MovieModel
import com.example.moviescatalog.viewmodel.DetailViewModel


class Favorites : Fragment(),FavoritesRecyclerViewAdapter.OnItemClickCallback{

    private var recyclerViewAdapter: FavoritesRecyclerViewAdapter? = null
    private lateinit var favoriteViewModel: DetailViewModel
    private lateinit var movieModel:MovieModel
    private lateinit var favoriteMovieDatabase: FavoriteMovieDatabase
    private var favoritesRecyclerViewAdapter: FavoritesRecyclerViewAdapter? = null
    private lateinit var favoritesDatabase: FavoriteMovieDatabase
    lateinit var binding: FragmentFavoritesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavoritesBinding.inflate(layoutInflater)
        val view = binding.root

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
        binding.favoritesrecyclerview.layoutManager = layoutManager







        /*

        arguments?.let {
            movieId = FavoritesArgs.fromBundle(it).movieId

        }

         */
        /*

        favoriteViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        favoriteViewModel.getAllMoviesObservers().observe(viewLifecycleOwner, Observer {
            recyclerViewAdapter.setMovieList(it)
            Log.d("msg",it.get(0).original_title)
            Log.d("msg",it.size.toString())
            Log.d("msg","a")
                binding.apply {
                    binding.favoritesrecyclerview.setHasFixedSize(true)
                    binding.favoritesrecyclerview.adapter = recyclerViewAdapter
                }

            /*
                recyclerViewAdapter = FavoritesRecyclerViewAdapter(it as ArrayList<FavoriteMovieModel>,this@Favorites)
                binding.favoritesrecyclerview.adapter = recyclerViewAdapter
                favoriteViewModel.getAllMovies()

             */


        })

         */
        return view




        /*
        recyclerViewAdapter.setOnItemClickCallback(object : FavoritesRecyclerViewAdapter.OnItemClickCallback{
            override fun onDeleteClick(favoriteMovieModel: FavoriteMovieModel) {
                TODO("Not yet implemented")
            }

            override fun onItemClick(favoriteMovieModel: FavoriteMovieModel) {
                val movie = FavoriteMovieModel(
                        movieModel.original_title,
                        movieModel.poster_path

                    )

                /*

                    val action = FavoritesDirections.actionFavorites2ToMovieDetailFragment(movie)
                findNavController().navigate(action)

                 */


            }

        }
        )

         */



    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoritesBinding.bind(view)
        favoriteViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val adapter = FavoritesRecyclerViewAdapter()
        favoriteViewModel.getAllMoviesObservers().observe(viewLifecycleOwner){
            adapter.setMovieList(it)
            binding.apply {
                favoritesrecyclerview.setHasFixedSize(true)
                favoritesrecyclerview.adapter = adapter
            }
        }

        adapter.setOnItemClickCallback(object : FavoritesRecyclerViewAdapter.OnItemClickCallback{
            override fun onItemClick(favoriteMovieModel: FavoriteMovieModel) {
                val movie = FavoriteMovieModel(
                    movieModel.original_title,
                    movieModel.poster_path
                )


                /*
                binding.favToolbar.customToolbar.setNavigationOnClickListener {
                    val action = FavoritesDirections.actionFavorites2ToMovieDetailFragment(movie)
                    findNavController().navigate(action)
                }

                 */





            }


            override fun onDeleteClick(favoriteMovieModel: FavoriteMovieModel) {
                favoriteViewModel.deleteMovieİnfo(favoriteMovieModel)

            }

        })

        //clickBackButton()
    }

    override fun onDeleteClick(favoriteMovieModel: FavoriteMovieModel) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(favoriteMovieModel: FavoriteMovieModel) {
        TODO("Not yet implemented")
    }



    /*
    private fun clickBackButton(){
        binding.favToolbar.customToolbar.setNavigationOnClickListener {
            val action = FavoritesDirections.actionFavorites2ToMovieDetailFragment()
            findNavController().navigate(action)
        }
    }

     */


}


