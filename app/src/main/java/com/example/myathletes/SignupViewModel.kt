package com.example.myathletes

import android.app.Application
import androidx.lifecycle.*
import com.example.myathletes.database.Signup
import com.example.myathletes.database.SignupDao
import kotlinx.coroutines.launch

/**
 * IntersectionViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values.
 */
class SignupViewModel(
    val database: SignupDao, // Data access object for the Intersection entity
    application: Application) : AndroidViewModel(application) {

    var name = MutableLiveData("")
    var location = MutableLiveData("")

    // Retrieves all Intersection objects from the database
    // Represented as a LiveData<List<Intersection>>

    /**
     * Creates a LiveData<String> that contains information from all Intersection objects.
     * The Transformations.map function takes a LiveData object, performs operations on the
     * object and returns a LiveData-wrapped object.
     */
    val signupList = database.getAllSignups()
    var signupString = Transformations.map(signupList) {
            signups -> // intersections refer to the underlying data List<Intersection>
        var result = ""
        // Retrieve each Intersection object from the list
        for (signup in signups) {
            // Create a string using the Intersection name and location.
            // The intersection string is appended to a longer string with all intersections.
            result += "${signup.signupId} @ ${signup.email}\n"
        }
        // Returns the aggregated String that is wrapped by the map function in a LiveData object.
        result
    }

    /**
     * Inserts the Intersection object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create Intersection object using data stored in the EditText views
            var signup = Signup()
            signup.name = name.value.toString()
            signup.email = location.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(signup)
        }

    }

    /**
     * Deletes all Intersection entities in the database.
     */
    fun clear() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Delete data from the database using the clear coroutine.
            database.clear()
        }
    }
}