package com.smartgeek.gdseventapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.commit
import com.google.android.material.navigation.NavigationBarView
import com.smartgeek.gdseventapp.databinding.ActivityMainPageBinding

class MainPage : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainPageBinding
    private lateinit var profileIcon: ImageView
    private lateinit var title: TextView
    private lateinit var searchIcon: ImageView
    private lateinit var ticketIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)

        profileIcon = findViewById(R.id.iv_profile)
        profileIcon.setOnClickListener { startActivity(Intent(this, ViewMyProfile::class.java)) }

        title = findViewById(R.id.textView_title)
    }


    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.nav_event -> onClickEvent()
        R.id.nav_connect -> onClickConnect()
        R.id.nav_invite -> onClickInvite()
        R.id.nav_chats -> onClickChats()
        else -> false
    }


    @SuppressLint("SetTextI18n")
    private fun onClickChats(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, ChatsFragment())
            title.text = "Chats"
        }
        return true
    }


    @SuppressLint("SetTextI18n")
    private fun onClickInvite(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, InviteFragment())
            title.text = "Invite"
        }
        return true
    }


    @SuppressLint("SetTextI18n")
    private fun onClickConnect(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, ConnectFragment())
            title.text = "Connect"
        }
        return true
    }


    @SuppressLint("SetTextI18n")
    private fun onClickEvent(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, EventFragment())
            title.text = "Events"
        }
        return true
    }
}