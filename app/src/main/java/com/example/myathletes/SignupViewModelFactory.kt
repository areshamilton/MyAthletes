package com.example.myathletes


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myathletes.database.SignupDao

/**
 * Generates an IntersectionViewModel tied to the database.
 */
class SignupViewModelFactory(
    private val dataSource: SignupDao, // Data access object
    private val application: Application): ViewModelProvider.Factory {


    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignupViewModel::class.java)) { // ViewModel class
            return SignupViewModel(dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}