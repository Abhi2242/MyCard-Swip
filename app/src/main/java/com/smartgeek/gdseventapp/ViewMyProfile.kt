package com.smartgeek.gdseventapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ViewMyProfile : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_my_profile)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_profile ->{
            }
        }
    }
}