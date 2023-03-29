package com.example.moviescatalog.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.moviescatalog.*
import com.example.moviescatalog.adapter.RecyclerViewAdapter
import com.example.moviescatalog.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private var recyclerViewAdapter : RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.search -> {
                    searchFragment(Search())
                    true
                }
                R.id.watchlist -> {
                    watchListFragment(WatchList())
                    true
                }
                R.id.favorites -> {
                    favoritesFragment(Favorites())
                    true
                }

                else -> false
            }
        }

    }

    fun searchFragment(view: Search){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val searchFragment = Search()
        fragmentTransaction.replace(R.id.frame_layout,searchFragment).commit()
    }
    fun favoritesFragment(view: Favorites){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val favoritesFragment = Favorites()
        fragmentTransaction.replace(R.id.frame_layout,favoritesFragment).commit()
    }

    fun watchListFragment(view : WatchList){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val watchListFragment = WatchList()
        fragmentTransaction.replace(R.id.frame_layout,watchListFragment).commit()
    }
}