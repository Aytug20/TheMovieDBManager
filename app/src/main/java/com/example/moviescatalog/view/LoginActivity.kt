package com.example.moviescatalog.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescatalog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        Log.d("Message","Hata")

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)

        //https://api.themoviedb.org/3/search/movie?api_key=be00c5443a064dc182fd6021eb753a57&language=en-US&page=1&include_adult=false
        //be00c5443a064dc182fd6021eb753a57

        supportActionBar?.hide()
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding.btnLogin.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            if(email.equals("") || password.equals("")) {
                Toast.makeText(this,"Eposta ve şifrenizi giriniz!",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Giris yaptınız!",Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

        binding.btnWeb.setOnClickListener {
            val url = "https://www.themoviedb.org/movie"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }

}