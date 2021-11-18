package com.example.myathletes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myathletes.databinding.FragmentHomeBinding


class Home : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.timerButton.setOnClickListener {view: View ->
            view.findNavController().navigate(HomeDirections.actionHome2ToTimer(binding.workoutName.text.toString())) }

        return binding.root
    }

}