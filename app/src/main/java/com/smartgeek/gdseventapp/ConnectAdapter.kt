package com.smartgeek.gdseventapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartgeek.gdseventapp.databinding.ConnectCarouselItemBinding

class ConnectAdapter(private var connectList: ArrayList<Profile>) :
    RecyclerView.Adapter<ConnectAdapter.ConnectViewHolder>() {


    // swipe gesture code
    private lateinit var myListener: OnItemClickListener

    // to view the details of current clicked profile
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        myListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(i: Int){
        connectList.removeAt(i)
        notifyDataSetChanged()
    }
    // end of swipe Gesture code


    class ConnectViewHolder(val binding: ConnectCarouselItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectViewHolder {
        val binding =
            ConnectCarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConnectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConnectViewHolder, position: Int) {
        val profile = connectList[position]
        holder.binding.apply {
            Glide.with(ivShowProfile).load(connectList[position].image).into(ivShowProfile)
            tvPn.text = profile.profileName
            tvCn.text = profile.companyName
            tvDesignation.text = profile.designations
            tvSkills.text = profile.skills
        }
    }


    override fun getItemCount(): Int = connectList.size
}