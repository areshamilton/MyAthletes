package com.example.myathletes



import android.net.Uri

//type will provide a radio group of athlete or coach

class Credentials(val type: String, val email: String, val number: String, val password: String) {
    fun display_type(){
        println("$type")
    }
}