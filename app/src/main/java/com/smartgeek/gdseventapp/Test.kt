package com.smartgeek.gdseventapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

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
}