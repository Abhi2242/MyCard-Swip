package com.smartgeek.gdseventapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smartgeek.gdseventapp.databinding.ActivityEventFragmentBinding
import java.util.ArrayList

class EventFragment : Fragment() {

    private lateinit var bindingEvent: ActivityEventFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingEvent = ActivityEventFragmentBinding.inflate(inflater, container, false)

        val eventList = ArrayList<EventModel>()
        eventList.add(
            EventModel(
                R.drawable.test_img, "Goa Developer's Summit", "Ravindra Bhavan-Margao",
                "16th October 2022", "10:00AM - 5:00PM",
                "Connect with people with similar interests attending the same events. " +
                        "Goa Chamber of Commerce & Industry Presents - Goa's First ever developers summit",
            "This is Long Description Connect with people with similar interests attending the same events. " +
                                           "Goa Chamber of Commerce & Industry Presents - Goa's First ever developers summit"))

        eventList.add(
            EventModel(
                R.drawable.carousel_01, "Goa Developer's Meet", "Ravindra Bhavan-Margao",
                "16th October 2022", "10:00AM - 5:00PM",
                "Connect with people with similar interests attending the same events. " +
                        "Goa Chamber of Commerce & Industry Presents - Goa's First ever developers summit",
                "This is Long Description Connect with people with similar interests attending the same events. " +
                        "Goa Chamber of Commerce & Industry Presents - Goa's First ever developers summit"))

        val adaptor = EventAdapter(eventList)

        bindingEvent.apply {
            eventCarousel.adapter = adaptor
            eventCarousel.set3DItem(false)
            eventCarousel.setAlpha(false)
            eventCarousel.setInfinite(true)
        }
        return bindingEvent.root
    }
}