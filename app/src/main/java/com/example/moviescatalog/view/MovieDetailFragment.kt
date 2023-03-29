package com.example.moviescatalog.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ToggleButton
import androidx.lifecycle.ViewModelProvider
import com.example.moviescatalog.databinding.FragmentMovieDetailBinding
import com.example.moviescatalog.imageLoad
import com.example.moviescatalog.local.*
import com.example.moviescatalog.model.MovieModel
import com.example.moviescatalog.viewmodel.DetailViewModel
import com.example.moviescatalog.local.WatchListModel
import com.example.moviescatalog.local.WatchListViewModel
import com.google.gson.Gson


class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var toggleButton: ToggleButton
    private var movieModel:MovieModel? = null
    private var movieList: ArrayList<MovieModel> = arrayListOf()
    private lateinit var movie: MovieModel
    private lateinit var favoritesDatabase: FavoriteMovieDatabase
    private lateinit var detailViewModel:DetailViewModel
    private lateinit var watchListViewModel: WatchListViewModel
    private var favoriteMovieModel:FavoriteMovieModel? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater,container,false)
        val view = binding.root
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        watchListViewModel = ViewModelProvider(this).get(WatchListViewModel::class.java)
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //observeDetailLiveData()

        val jsonDetail = arguments?.getString("movie")
        if (jsonDetail != null) {
            movieModel = Gson().fromJson(jsonDetail,MovieModel::class.java)
            movieModel?.let {
                var isChecked = false
                val user = FavoriteMovieModel(movieModel!!.original_title,movieModel!!.poster_path)
                val wuser = WatchListModel(movieModel!!.original_title,movieModel!!.poster_path)
                binding.textVote.setText(it.vote_average)
                binding.movieDescription.setText(it.overview)
                binding.movieImage.imageLoad(it.backdrop_path)
                binding.toggleFavorite.setOnClickListener {
                    isChecked = !isChecked
                    if(isChecked){
                        detailViewModel.insertMovieİnfo(user)

                    }else{
                        detailViewModel.deleteMovieİnfo(user)
                    }
                    binding.toggleFavorite.isChecked = isChecked

                }


                binding.toogleWatchlist.setOnClickListener {
                    isChecked =!isChecked
                    if (isChecked){
                        watchListViewModel.insertWatchMovieİnfo(wuser)
                    }else{
                        watchListViewModel.deleteWatchMovieİnfo(wuser)
                    }
                    binding.toogleWatchlist.isChecked = isChecked
                }





                /*
                var isChecked = false
                CoroutineScope(Dispatchers.IO).launch {
                    val count = detailViewModel.verileriCheck(movieModel!!.uuid)
                    withContext(Dispatchers.Main){
                        if (count > 0){
                            binding.toggleFavorite.isChecked = true
                            isChecked = true
                        }else{
                            binding.toggleFavorite.isChecked = false
                            isChecked = false
                        }
                    }

                }

                 */


                /*
                binding.toggleFavorite.setOnClickListener {
                    val action = MovieDetailFragmentDirections.actionMovieDetailFragmentToFavorites2(movieList.get(id).uuid)
                    Navigation.findNavController(it).navigate(action)
                }

                 */

                /*


                var isChecked = false
                CoroutineScope(Dispatchers.IO).launch {
                    val count = detailViewModel.
                    withContext(Dispatchers.Main){
                        if (count > 0){
                            binding.toggleFavorite.isChecked = true
                            isChecked = true
                        }else{
                            binding.toggleFavorite.isChecked = false
                            isChecked = false
                        }
                    }
                }

                 */
                /*

                binding.toggleFavorite.setOnClickListener {
                    isChecked = !isChecked
                    if(isChecked){
                        detailViewModel.verileriSQLitetanAl()
                    }else{
                        detailViewModel.verileriSil()
                    }
                    binding.toggleFavorite.isChecked = isChecked
                }

                 */




            }

        }
    }




/*
    override fun onItemClick(movieModel: MovieModel) {
        arguments?.let {
            movieId = MovieDetailFragmentArgs.fromBundle(it).movieId

        }

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.loadData(movieId.toString())

        observeDetailLiveData()
    }



    fun observeDetailLiveData(){
        viewModel.movieDetailLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null){
                    val jsonDetail = arguments?.getString("movie")
                    if (jsonDetail != null) {
                        movieModel = Gson().fromJson(jsonDetail,MovieModel::class.java)
                        movieModel?.let {
                            binding.movieDescription.setText(it.overview)
                            binding.movieImage.imageLoad(it.backdrop_path)
                        }

                    }
            }else{
            Toast.makeText(activity, "Error in getting list", Toast.LENGTH_SHORT).show()
        }
        })
    }

 */



/*
    fun setInitialData() {

            val jsonDetail = arguments?.getString("movie")
            if (jsonDetail != null) {
                movieModel = Gson().fromJson(jsonDetail,MovieModel::class.java)
                movieModel?.let {

                    binding.movieDescription.setText(it.overview)
                    binding.movieImage.imageLoad(it.backdrop_path)


                }

            }

    }

 */

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
/*
    var isChecked = false
    CoroutineScope(Dispatchers.IO).launch {
        val count = detailViewModel.checkMovie(movie.id)
        withContext(Dispatchers.Main){
            if (count > 0){
                binding.toggleFavorite.isChecked = true
                isChecked = true
            }else{
                binding.toggleFavorite.isChecked = false
                isChecked = false
            }
        }
    }

    binding.toggleFavorite.setOnClickListener {
        isChecked = !isChecked
        if(isChecked){
            detailViewModel.addToFavorite(movie)
        }else{
            detailViewModel.removeFromFavorite(movie.id)
        }
        binding.toggleFavorite.isChecked = isChecked
    }

 */



}
