package com.example.myathletes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// data class that represents a Video entity

@Entity(tableName = "workout_table")
data class Workout(

    // primary key
    @PrimaryKey(autoGenerate = true)
    var workoutId: Long = 0L,

    // name of workout
    @ColumnInfo()
    var name: String = "",

    // description of workout
    @ColumnInfo()
    var description: String = "",

    // link to video (which is a photo for now)
    @ColumnInfo()
    var link: String = ""
)