package com.smartgeek.gdseventapp

data class EventModel(
    var eventImage: Int,
    var eventTitle: String,
    var eventLocation: String,
    var eventDate: String,
    var eventTime: String,
    var eventDescription: String,
    var eventLongDescription: String
)