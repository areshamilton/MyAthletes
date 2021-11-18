package com.example.myathletes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myathletes.database.WorkoutDao

// Generates an WorkoutViewModel tied to the database
class WorkoutViewModelFactory(
    private val dataSource: WorkoutDao,
    private val application: Application): ViewModelProvider.Factory {

        /**
         * Creates the IntersectionViewModel
         */
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WorkoutViewModel::class.java)) { // ViewModel class
                return WorkoutViewModel(dataSource, application) as T // Call ViewModel constructor
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }