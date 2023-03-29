package com.example.moviescatalog.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescatalog.R
import com.example.moviescatalog.adapter.RecyclerViewAdapter
import com.example.moviescatalog.databinding.FragmentMovieListBinding
import com.example.moviescatalog.model.MovieModel
import com.example.moviescatalog.viewmodel.ListViewModel
import com.google.gson.Gson
import kotlin.math.E


class MovieListFragment : Fragment() , RecyclerViewAdapter.Listener{
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private var movieModels: ArrayList<MovieModel> = arrayListOf()
    private var recyclerViewAdapter : RecyclerViewAdapter? = null
    private lateinit var searchView: SearchView
    private lateinit var viewModel: ListViewModel
    private var movieId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        val view = binding.root

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.observeViewModel().observe(viewLifecycleOwner, Observer {
            if(it != null){
                recyclerViewAdapter = RecyclerViewAdapter(it as ArrayList<MovieModel>,this@MovieListFragment)
                binding.recyclerView.adapter = recyclerViewAdapter
            }else{
                Toast.makeText(activity,"Error in getting list",Toast.LENGTH_SHORT).show()
            }

        })

        searchView = binding.searchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                   if (query!!.isNotEmpty()) {
                        viewModel.loadData(query)
                    }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText!!.isNotEmpty()) {
                    viewModel.loadData(newText.toString())
                } else {
                    viewModel.clearData()
                }
                return true
            }
        })


        return view
    }

    override fun onItemClick(movieModel: MovieModel) {
        Toast.makeText(requireContext(),"movie - ${movieModel.original_title}",Toast.LENGTH_SHORT).show()
        val bundle = Bundle()
        bundle.putString("movie",Gson().toJson(movieModel))
        findNavController().navigate(R.id.action_movieListFragment_to_movieDetailFragment,bundle)

        /*
        binding.recyclerView.setOnClickListener {
            val action = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(3)
            Navigation.findNavController(it).navigate(action)
        }

         */


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}