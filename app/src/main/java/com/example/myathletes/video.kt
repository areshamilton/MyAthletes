package com.example.myathletes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
// TODO: use YouTube Player API to embed the video demonstration
// TODO: find out if a database or list would be more suitable for Video objects
// Video class contains the name of the workout, a description of the workout, and a video demonstration
class Video() {

    // the properties use live data
    private val _workout = MutableLiveData("")
    private val _description = MutableLiveData("")
    private val _link = MutableLiveData("")

    val workout: LiveData<String>
        get() {
            return _workout
        }
    val description: LiveData<String>
        get() {
            return _description
        }
    val link: LiveData<String>
        get() {
            return _link
        }

    init {
        _workout.value = ""
        _description.value = ""
        _link.value = ""
    }

    // fills a Video object with given info
    fun updateInfo(workout: String, description: String, link: String) {
        _workout.value = workout!!
        _description.value = description!!
        _link.value = link!!
    }

}