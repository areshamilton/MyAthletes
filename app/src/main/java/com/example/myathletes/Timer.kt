package com.example.myathletes

class Timer {
    // Will add a timer that can be configured

    // enum to track the timer current state
    enum class TimerState{
        Stopped, Paused, Running, Rest
    }

    private val timer = Timer()

    fun startTimer(){
        // TODO: when start button is clicked, timer progress bar will countdown
    }

    fun onPause(){
        // TODO: when button is clicked, timer and progress will stop. future option to use rest time
    }

    fun onResume(){
        // TODO: when button is clicked, time will resume and if rest time is running, it will paused as well
    }

    // once we can save and load workout plans, we will pass in the dataset
    // and it will be outputted in the fragment timer
    // use class activity intersection list as the base

    // in .xml place style="@style/Widget.MaterialProgressBar.ProgressBar" in the
    // progress bar section to hide it until code is implemented



}