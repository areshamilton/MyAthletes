package com.example.myathletes


import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.myathletes.database.SignupDatabase
import com.example.myathletes.databinding.CredentialsBinding

//type will provide a radio group of athlete or coach

class Credentials : Fragment() {

   override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


       val binding: CredentialsBinding =
           DataBindingUtil.inflate(inflater, R.layout.credentials,container, false)
    // Get reference to this application
     val application = requireActivity().application
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

    return binding.root
    }
}