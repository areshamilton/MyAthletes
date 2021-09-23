package com.example.myathletes

// Video class contains the name of the workout, a description of the workout, and a video demonstration
// TODO: use YouTube Player API to embed the video demonstration
class Video(val workout: String, val description: String, val link: String) {

    // method that displays the Video object's properties
    fun displayInfo() {
        println("$workout")
        println("$description")
        println("$link")
    }
}