package com.example.moviescatalog.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviescatalog.R

class SearchActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_screen)

        /*
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.search ->{
                    searchFragment(Search())
                    true
                }

                R.id.favorites->{
                    favoritesFragment(Favorites())
                    true
                }
                R.id.watchlist ->{
                    watchListFragment(WatchList())
                    true

                }
                else -> {

                }
            }
            true
        }

         */
    }


}


