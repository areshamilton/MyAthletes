package com.example.myathletes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myathletes.database.SignupDatabase
import com.example.myathletes.databinding.ActivityMainBinding
import com.example.myathletes.databinding.SignupBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create data binding
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Get reference to this application
        val application = requireNotNull(this).application

        // Retrieve Intersection data access object.
        val dataSource = SignupDatabase.getInstance(application).signupDao

        // Create a factory that generates IntersectionViewModels connected to the database.
        val viewModelFactory = SignupViewModelFactory(dataSource, application)

        // Generate an IntersectionViewModel using the factory.
        val signupViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(SignupViewModel::class.java)

        // Connect the IntersectionViewModel with the variable in the layout
        binding.signupViewModel = signupViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

    }
}