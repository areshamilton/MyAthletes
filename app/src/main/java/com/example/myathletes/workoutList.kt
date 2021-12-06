package com.example.myathletes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myathletes.R
import com.example.myathletes.database.WorkoutDatabase
import com.example.myathletes.databinding.WorkoutListBinding

class workoutList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Create data binding
        val binding: WorkoutListBinding =
            DataBindingUtil.inflate(inflater, R.layout.workout_list, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve Workout data access object.
        val dataSource = WorkoutDatabase.getInstance(application).workoutDao

        // Create a factory that generates IntersectionViewModels connected to the database.
        val viewModelFactory = WorkoutViewModelFactory(dataSource, application)

        // Generate an IntersectionViewModel using the factory.
        val workoutViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(WorkoutViewModel::class.java)

        // Connect the WorkoutViewModel with the variable in the layout
        binding.workoutViewModel = workoutViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        // Provide a lambda function that is called when the RecyclerView item is selected.
        var workoutAdapter = WorkoutListAdapter(WorkoutListener {
                workoutId ->
            // Navigate to the videoPage view and provide the id of the intersection referenced
            // by the select RecyclerView item.
            this.findNavController().navigate(workoutListDirections.actionWorkoutListToVideoPage(
                workoutId
            )
            )
        })
        // Attach workout adapter.
        binding.workoutRecyclerview.adapter = workoutAdapter

        // Submit an updated list to the workout listAdapter whenever it changes.
        workoutViewModel.workoutList.observe(viewLifecycleOwner, Observer {
            it?.let {
                workoutAdapter.submitList(it)
            }
        })

        // Returns a link to the layout root
        return binding.root
    }

}