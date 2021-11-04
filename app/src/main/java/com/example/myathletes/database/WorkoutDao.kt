package com.example.myathletes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myathletes.database.Workout

/**
 * Data access object for the Workout entity. The class describes how data is
 * stored, updated, retrieved, or deleted from the database.
 */
@Dao
interface WorkoutDao {
    // Add a Workout entity to a table in the database.
    // We use suspend to run the function asynchronously (coroutine).
    @Insert
    suspend fun insert(workout: Workout)

    // Update a workout entity to a table in the database. Often uses the primary key
    // We use suspend to run the function asynchronously (coroutine).
    @Update
    suspend fun update(workout: Workout)

    // Custom query for retrieving a single Workout from a table in the database using
    // its workout id. We don't use suspend because LiveData objects are already designed
    // to work asynchronous.
    @Query("SELECT * from workout_table WHERE workoutId = :key")
    fun get(key: Long): LiveData<Workout>?

    // Custom query for retrieving all Workout entities from a table in the database.
    // Data is stored to a List LiveData. We don't use suspend because LiveData objects
    // are already designed to work asynchronously.
    @Query("SELECT * from workout_table ORDER BY workoutId DESC")
    fun getAllWorkouts(): LiveData<List<Workout>>

    // Custom query for deleting all entities on a table in the database
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from workout_table")
    suspend fun clear()
}