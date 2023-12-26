package com.smartgeek.gdseventapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShowEventDetails : AppCompatActivity() {

    private lateinit var profileIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_event_details)

        profileIcon = findViewById(R.id.iv_profile)
        profileIcon.setOnClickListener { startActivity(Intent(this, ViewMyProfile::class.java)) }

        val eTitle = intent.getStringExtra("Title")
        val eVenue = intent.getStringExtra("Venue")
        val eDate = intent.getStringExtra("Date")
        val eTime = intent.getStringExtra("Time")
        val eDescription = intent.getStringExtra("LongDescription")

        val title: TextView = findViewById(R.id.tv_text1)
        title.text = eTitle

        val venue: TextView = findViewById(R.id.tv_text2)
        venue.text = eVenue

        val date: TextView = findViewById(R.id.tv_text3)
        date.text = eDate

        val time: TextView = findViewById(R.id.tv_text4)
        time.text = eTime

        val lDescription: TextView = findViewById(R.id.tv_text5)
        lDescription.text = eDescription
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}