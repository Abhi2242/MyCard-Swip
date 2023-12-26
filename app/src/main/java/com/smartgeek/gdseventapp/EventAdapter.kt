package com.smartgeek.gdseventapp

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartgeek.gdseventapp.databinding.EventCarouselItemBinding

class EventAdapter(private var eventList: List<EventModel>): RecyclerView.Adapter<EventAdapter.EventViewHolder>(){
    class EventViewHolder(val binding: EventCarouselItemBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = EventCarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.binding.apply {
            Glide.with(ivEventImage).load(eventList[position].eventImage).into(ivEventImage)
            tvEventTitle.text = event.eventTitle
            tvEventLocation.text = event.eventLocation
            tvEventDate.text = event.eventDate
            tvEventTime.text = event.eventTime
            tvEventDescription.text = event.eventDescription

                btnEcBuy.setOnClickListener {
                val context1 = holder.binding.root.context
                val intent= Intent(context1, ShowEventDetails::class.java).apply {
                    putExtra("Title", tvEventTitle.text)
                    putExtra("Venue", tvEventLocation.text)
                    putExtra("Date", tvEventDate.text)
                    putExtra("Time", tvEventTime.text)
                    putExtra("LongDescription", event.eventLongDescription)
                }
                context1.startActivity(intent)
            }
        }
    }


    override fun getItemCount(): Int = eventList.size
}