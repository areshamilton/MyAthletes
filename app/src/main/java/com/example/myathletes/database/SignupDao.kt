package com.example.myathletes.database

import android.provider.ContactsContract



import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Data access object for the Intersection entity. The class describes how data is
 * stored, updated, retrieved, or deleted from the database.
 */
@Dao
interface SignupDao {
    // Add an intersection entity to a table in the database.
    // We use suspend to run the function asynchronously (coroutine).
    @Insert
    suspend fun insert(signup: Signup)

    // Update an intersection entity to a table in the database. Often uses the primary key
    // We use suspend to run the function asynchronously (coroutine).
    @Update
    suspend fun update(signup: Signup)

    // Custom query for retrieving a single Intersection from a table in the database using
    // its intersection id. We don't use suspend because LiveData objects are already designed
    // to work asynchronous.
    @Query("SELECT * from signup_table WHERE signupId = :key")
    fun get(key: Long): LiveData<Signup>?

    // Custom query for retrieving all Intersection entities from a table in the database.
    // Data is stored to a List LiveData. We don't use suspend because LiveData objects
    // are already designed to work asynchronously.
    @Query("SELECT * from signup_table ORDER BY signupId DESC")
    fun getAllSignups(): LiveData<List<Signup>>

    // Custom query for deleting all entities on a table in the database
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from signup_table")
    suspend fun clear()
}