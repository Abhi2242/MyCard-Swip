package com.smartgeek.gdseventapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smartgeek.gdseventapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieList = ArrayList<MovieModel>()
        movieList.add(
            MovieModel(
                R.drawable.carousel_01,
                "Connect with people with similar interests attending the same events"))

        movieList.add(
            MovieModel(
                R.drawable.carousel_02,
                "View all events happening near you in one place"))

        movieList.add(
            MovieModel(
                R.drawable.carousel_03,
                "Book tickets quickly and easily within the app"))


        val adaptor = MovieAdapter(movieList)

        binding.apply {
            carousel.adapter = adaptor
            carousel.set3DItem(false)
            carousel.setAlpha(false)
            carousel.setInfinite(false)
            btnMobile.setOnClickListener { startActivity(Intent(this@MainActivity, MobileLogInActivity::class.java)) }
            btnEmail.setOnClickListener { startActivity(Intent(this@MainActivity, MainPage::class.java)) }
        }
    }
}
