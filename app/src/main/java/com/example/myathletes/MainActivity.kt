package com.example.myathletes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myathletes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // using a binding object for the visuals
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = this.findNavController(R.id.nav_host)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    // allows use of the up button
    override fun onSupportNavigateUp(): Boolean {
        // Replace nav_host with the name of your nav host fragment in activity_main.xml
        val navController = this.findNavController(R.id.nav_host)
        return navController.navigateUp()
    }
}