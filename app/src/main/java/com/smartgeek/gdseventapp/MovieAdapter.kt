package com.smartgeek.gdseventapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartgeek.gdseventapp.databinding.CarouselItemBinding

class MovieAdapter(private var movieList: List<MovieModel>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(val binding: CarouselItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.apply {
            Glide.with(ivMovieImage).load(movieList[position].image).into(ivMovieImage)
            tvMovieName.text = movie.name
        }
    }

    override fun getItemCount(): Int = movieList.size
}