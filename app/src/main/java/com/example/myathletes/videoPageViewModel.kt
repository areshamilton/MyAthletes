package com.example.myathletes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myathletes.database.WorkoutDao

class VideoPageViewModel(
    val workoutId: Long,
    val database: WorkoutDao, // Data access object for the Intersection entity
    application: Application
) : AndroidViewModel(application) {

    // Retrieves a LiveData-wrapped intersection object given its ID
    val workout = database.get(workoutId)
}