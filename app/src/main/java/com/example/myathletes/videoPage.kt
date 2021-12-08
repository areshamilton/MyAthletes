package com.example.myathletes

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myathletes.database.WorkoutDao
import com.example.myathletes.database.WorkoutDatabase
import com.example.myathletes.databinding.VideoPageBinding

class videoPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Retrieve arguments passed from the RecyclerView
        val args = videoPageArgs.fromBundle(
            requireArguments()
        )

        // Create data binding
        val binding: VideoPageBinding =
            DataBindingUtil.inflate(inflater, R.layout.video_page, container, false)

        // Get reference to this application
        val application = requireNotNull(this.activity).application

        // Retrieve Intersection data access object.
        val dataSource = WorkoutDatabase.getInstance(application).workoutDao

        // Create a factory that generates a videoPageViewModel connected to the database. The
        // workoutId passed from the RecyclerView is used to display the corresponding
        // information
        val viewModelFactory =
            IntersectionItemViewModelFactory(args.workoutId, dataSource, application)

        // Generate a videoPageViewModel using the factory.
        val videoPageViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(VideoPageViewModel::class.java)


        // Connect the videoPageViewModel with the variable in the layout
        binding.videoPageViewModel = videoPageViewModel



        //change image display based
        // IMPORTANT: The workoutId does NOT reset upon clearing the database,
        //            so these values are relative to where workoutId currently is
        if (args.workoutId == 15L) {
            binding.photo.setImageResource(R.drawable.bench_press)
        }
        if (args.workoutId == 16L) {
            binding.photo.setImageResource(R.drawable.treadmill)
        }
        if (args.workoutId == 17L) {
            binding.photo.setImageResource(R.drawable.squats)
        }

        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this





        return binding.root
    }

}