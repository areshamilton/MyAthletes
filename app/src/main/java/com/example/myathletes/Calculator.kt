package com.example.myathletes

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myathletes.databinding.CalculatorBinding
import java.util.*

const val effortThreshold = 0.00

class Calculator : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: CalculatorBinding =
            DataBindingUtil.inflate(inflater, R.layout.calculator,container, false)

        return binding.root
    }
}

/*
fun calcWorkout (current: Double, attempt: Double) : Double {

    return workoutEval(current, attempt)
}

//workoutEval will do the actual calculations comparing the current workout to desired thresholds
// If actual work exerted is less than the expected weight attempted
fun workoutEval (workExerted: Double, weightAttempted: Double): Double {

    return weightAttempted * effortThreshold
}
*/