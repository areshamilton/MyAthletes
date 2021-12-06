package com.example.myathletes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myathletes.database.WorkoutDao

class IntersectionItemViewModelFactory(
    private val intersectionId: Long,
    private val dataSource: WorkoutDao, // Data access object
    private val application: Application
): ViewModelProvider.Factory {

    /**
     * Creates the videoPageViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideoPageViewModel::class.java)) { // ViewModel class
            return VideoPageViewModel(intersectionId, dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}