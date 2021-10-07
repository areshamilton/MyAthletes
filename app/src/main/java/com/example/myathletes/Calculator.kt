package com.example.myathletes

// The calculator class will analyze a user's workout data and determine if the workout needs to be adjusted

// Placeholder value representing the threshold of work performed vs. work desired to see progress
const val effortThreshold = 0.00

abstract class Calculator () {

  //calcWorkout is the function that will be executed when the user hits "calculate"
  //Could retrieve workout data from multiple sources (including manual entry)
  //INCOMPLETE
  fun calcWorkout (current: Double, attempt: Double) : Double {

    return workoutEval(current, attempt)
  }

  //workoutEval will do the actual calculations comparing the current workout to desired thresholds
  // INCOMPLETE
  fun workoutEval (workExerted: Double, weightAttempted: Double): Double {

    return weightAttempted * effortThreshold
  }
  
}
