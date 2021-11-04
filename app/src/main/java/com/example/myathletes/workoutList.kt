package com.example.myathletes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.myathletes.databinding.WorkoutListBinding

class workoutList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        // Inflates the layout for this fragment
        val binding = WorkoutListBinding.inflate(layoutInflater)

        // USING THESE VIDEO OBJECTS FOR TESTING
        val benchPress = Video()
        benchPress.updateInfo("Bench Press", "used to train an " +
                "athlete's upper body as they push weights while lying on their back", "bench_press")
        val treadmill: Video = Video()
        treadmill.updateInfo("Treadmill","used to train an " +
                "athlete's cardio as they walk or run at a particular pace","treadmill")

        // clicking on a button brings us to that given workout's display page by passing the
        // properties of our object
        binding.benchPress.setOnClickListener { view: View ->
            view.findNavController().navigate(workoutListDirections.actionWorkoutListToVideoPage(
                benchPress.workout.value.toString(),
                benchPress.description.value.toString(),
                benchPress.link.value.toString()
            ))
        }
        binding.treadmill.setOnClickListener { view: View ->
            view.findNavController().navigate(workoutListDirections.actionWorkoutListToVideoPage(
                treadmill.workout.value.toString(),
                treadmill.description.value.toString(),
                treadmill.link.value.toString()
            ))
        }

        // TODO: add more buttons for other workouts

        // Returns a link to the layout root
        return binding.root
    }

}