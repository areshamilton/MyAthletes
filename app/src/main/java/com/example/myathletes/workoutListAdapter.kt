package com.example.myathletes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myathletes.database.Workout
import com.example.myathletes.databinding.WorkoutItemBinding

/**
 * A RecyclerView adapter that uses the DiffCallback for better performance and a listener to handle
 * clicks/taps on each item.
 */
class WorkoutListAdapter(val clickListener: WorkoutListener) : ListAdapter<Workout,
        WorkoutListAdapter.ItemViewHolder>(WorkoutDiffCallback()) {

    /**
     * Inner class used to store data about each element in the RecyclerView. We provide a binding
     * to make it easy to access elements of the layout.
     */
    class ItemViewHolder(val binding: WorkoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Assign a workout object and clickListener to the ItemViewHolder
         */
        fun bind(item: Workout, clickListener: WorkoutListener) {
            binding.workout = item
            binding.clickListener = clickListener
        }
    }

    /**
     * Creates a View to visualize one element in the RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // We use an inflater based on the parent (IntersectionListFragment) and create an
        // ItemViewHolder with binding to the layout to simplify access.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = WorkoutItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    /**
     * The function is called whenever the RecyclerView displays a specific element. It provides
     * access to the ItemViewHolder and its position.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Assign the corresponding element from the data and the click listener. Take note getItem
        // is a function provided by ListAdapter.
        holder.bind(getItem(position), clickListener)
    }
}

/**
 * Manages a RecyclerView list using the Eugene W. Myers's difference algorithm to reduce processing.
 */
class WorkoutDiffCallback : DiffUtil.ItemCallback<Workout>() {
    /**
     * We use workoutId because it is a unique ID referring to a single element.
     */
    override fun areItemsTheSame(oldItem: Workout, newItem: Workout): Boolean {
        return oldItem.workoutId == newItem.workoutId
    }

    /**
     * We check all properties to check equality between Workout objects.
     */
    override fun areContentsTheSame(oldItem: Workout, newItem: Workout): Boolean {
        return oldItem.name == newItem.name && oldItem.description == newItem.description
                                            && oldItem.link == newItem.link
    }
}

/**
 * Listener that accepts a lambda function clickListener. It will be called when an element of the
 * RecyclerView is clicked/tapped.
 */
class WorkoutListener(val clickListener: (intersectionId: Long) -> Unit) {
    fun onClick(workout: Workout) = clickListener(workout.workoutId)
}