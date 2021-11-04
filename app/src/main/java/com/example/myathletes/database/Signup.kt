package com.example.myathletes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "signup_table")
data class Signup(

    @PrimaryKey(autoGenerate = true)
    var signupId: Long = 0L,

    @ColumnInfo()
    var name: String = "",

    @ColumnInfo()
    var email: String = "",

    @ColumnInfo()
    var password: String = ""
)