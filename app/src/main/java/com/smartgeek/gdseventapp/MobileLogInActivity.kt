package com.smartgeek.gdseventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MobileLogInActivity : AppCompatActivity() {

    private lateinit var backBtn: ImageButton
    private lateinit var conti: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_log_in)

        backBtn = findViewById(R.id.btn_back)
        conti = findViewById(R.id.btn_conti)

        backBtn.setOnClickListener { startActivity(Intent(this,MainActivity::class.java)) }
        conti.setOnClickListener { startActivity(Intent(this,VerifyMobileLogIn::class.java)) }
    }
}