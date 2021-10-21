package com.example.myathletes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myathletes.databinding.WorkoutListBinding

class workoutList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        // Inflates the layout for this fragment
        val binding = WorkoutListBinding.inflate(layoutInflater)

        // USING THIS VIDEO OBJECT FOR TESTING
        val exampleVideo: Video = Video(workout = "Bench Press", description = "used to train an " +
                "athlete's upper body as they push weights while lying on their back", link = "bench_press")

        // clicking on the bench press button brings us to its display page by passing the
        // properties of our bench press object
        binding.benchPress.setOnClickListener { view: View ->
            view.findNavController().navigate(workoutListDirections.actionWorkoutListToVideoPage(
                exampleVideo.workout,
                exampleVideo.description,
                exampleVideo.link
            ))
        }

        // TODO: add more buttons for other workouts

        // Returns a link to the layout root
        return binding.root
    }

}