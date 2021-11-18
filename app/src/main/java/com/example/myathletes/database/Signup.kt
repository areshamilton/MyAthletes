package com.example.myathletes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "signup_table")
data class Signup(

    @PrimaryKey()
    var signupId: String = "",

    @ColumnInfo()
    var name: String = "",

    @ColumnInfo()
    var password: String = ""
)