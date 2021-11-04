package com.example.myathletes

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myathletes.databinding.VideoPageBinding

class videoPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflates the layout for this fragment
        val binding = VideoPageBinding.inflate(layoutInflater)

        // stores the Video object passed in and stores it into args
        val args = videoPageArgs.fromBundle(requireArguments())

        // displays the name of the workout
        binding.workout.text = args.workout

        // displays the description of the workout
        binding.description.text = args.description
        // TODO: get the margins to work properly

        // displays a photo of the workout
        // NOTE: using an image instead of a view until we learn how to use APIs
        // for now, the link is just the name of an image file
        if (args.link == "bench_press") {
            binding.photo.setImageResource(R.drawable.bench_press)
        } else if (args.link == "treadmill") {
            binding.photo.setImageResource(R.drawable.treadmill)
        }
        // TODO: this is hardcoded^^. Find out how to dynamically change images displayed.


        return binding.root
    }

}