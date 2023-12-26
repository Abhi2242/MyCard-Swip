package com.smartgeek.gdseventapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartgeek.gdseventapp.databinding.CustomChatProfileViewBinding

class ChatAdapter(private var chatList: ArrayList<Profile>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    class ChatViewHolder(val binding: CustomChatProfileViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = CustomChatProfileViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val profiles = chatList[position]
        holder.binding.apply {
            Glide.with(ivChatProfileList).load(chatList[position].image).into(ivChatProfileList)
            tvChatPn.text = profiles.profileName
        }
    }

    override fun getItemCount(): Int = chatList.size
}