package com.example.myathletes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // USING THIS OBJECT TO TEST DISPLAY FOR WORKOUTS
        val exampleVideo: Video = Video(workout = "Bench Press", description = "used to train an " +
                "athlete's upper body as they push weights while lying on their back", link = "bench_press")

        // displays the name of the workout
        var workoutDisplay: TextView = findViewById(R.id.workout)
        workoutDisplay.text = exampleVideo.workout

        // displays the description of the work
        var descriptionDisplay: TextView = findViewById(R.id.description)
        descriptionDisplay.text = exampleVideo.description

        // displays a photo of the workout
        // NOTE: using an image instead of a view until we learn how to use APIs
        // for now, the link is just the name of an image file
        var photoDisplay: ImageView = findViewById(R.id.photo)
        photoDisplay.setImageResource(R.drawable.bench_press)


        // TODO: implement data binding for cleaner code
        // TODO: figure out how to fix the margins
        // TODO: make everything look better

    }
}