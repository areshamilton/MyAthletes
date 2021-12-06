package com.example.myathletes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myathletes.databinding.MainmenuBinding

class Mainmenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding: MainmenuBinding =
            DataBindingUtil.inflate(inflater, R.layout.mainmenu,container, false)

        binding.timer.setOnClickListener(){ view: View ->
            view.findNavController()
                .navigate(R.id.action_main_menu_to_timer2)
        }

        binding.description.setOnClickListener(){ view: View ->
            view.findNavController()
                .navigate(R.id.action_main_menu_to_workoutList)
        }
        return binding.root
    }
}