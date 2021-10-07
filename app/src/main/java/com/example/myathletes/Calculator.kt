package com.example.myathletes

// The calculator class will analyze a user's workout data and determine if the workout needs to be adjusted

const val effortThreshold = 0.00

abstract class Calculator () {
  
  fun calcWorkout (current: Double, attempt: Double) : Double {

    return workoutEval(current, attempt)
  }
  
  fun workoutEval (workExerted: Double, weightAttempted: Double): Double {

    return weightAttempted * effortThreshold
  }
  
}
