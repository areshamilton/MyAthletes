package com.example.myathletes

import android.app.Application
import androidx.lifecycle.*
import com.example.myathletes.database.Workout
import com.example.myathletes.database.WorkoutDao
import kotlinx.coroutines.launch


// WorkoutViewModel used for data binding. Provides a connection to the database.
class WorkoutViewModel(
    val database: WorkoutDao, // Data access object for the Workout entity
    application: Application) : AndroidViewModel(application) {
    var name = MutableLiveData("")
    var description = MutableLiveData("")
    var link = MutableLiveData("")

    // retrieves all Workout objects from the database
    // represented as a LiveData<List<Workout>>
    val workoutList = database.getAllWorkouts()

    // creates a LiveData<String> that contains info from all Workout objects
    var workoutString = Transformations.map(workoutList) {
            workouts -> // workouts refer to the underlying data List<Workout>
        var result = ""
        // Retrieve each Workout object from the list
        for (workout in workouts) {
            // Create a string using the Workout name, description, and link.
            // The workout string is appended to a longer string with all workouts.
            result += "${workout.name}  ${workout.description}  ${workout.link}\n"
        }
        // returns the aggregated String that is wrapped by the map function in a LiveData object.
        result
    }

    // Inserts the Workout object into the database.
    fun insert() {
        // launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // create Workout object using data stored in the EditText views
            var workout = Workout()
            workout.name = name.value.toString()
            workout.description = description.value.toString()
            workout.link = link.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(workout)
        }
    }
    // Deletes all Workout entities in the database.
    fun clear() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Delete data from the database using the clear coroutine.
            database.clear()
        }
    }
}