package com.example.myathletes

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.myathletes.database.Signup
import com.example.myathletes.database.SignupDao
import com.example.myathletes.database.SignupDatabase
import kotlinx.coroutines.launch

/**
 * SignupViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values.
 */
class SignupViewModel(
    val database: SignupDao, // Data access object for the Intersection entity
    application: Application,
) : AndroidViewModel(application) {
    var name = MutableLiveData("")
    var password = MutableLiveData("")


    // Retrieves all Intersection objects from the database
    // Represented as a LiveData<List<Intersection>>

    /**
     * Creates a LiveData<String> that contains information from all Intersection objects.
     * The Transformations.map function takes a LiveData object, performs operations on the
     * object and returns a LiveData-wrapped object.
     */
    val signupList = database.getAllSignups()
    var signupString =
        Transformations.map(signupList) { signups -> // intersections refer to the underlying data List<Intersection>
            var result = ""
            // Retrieve each Intersection object from the list
            for (signup in signups) {
                // Create a string using the signup name and email.
                // The result string is appended to a longer string with all ids and emails.
                result += "${signup.name} has been added\n"
            }
            // Returns the aggregated String that is wrapped by the map function in a LiveData object.
            result
        }

    /**
     * Inserts the signup object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create Intersection object using data stored in the EditText views
            val signup = Signup()
            signup.name = name.value.toString()
            signup.password = password.value.toString()
            database.insert(signup)
        }
    }

    fun isUserNameCorrect(username: String): Boolean {
        if (username.equals(name.toString(), true)) {
            insert()
            return true
        }
        return false
    }

}