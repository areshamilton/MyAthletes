package com.example.myathletes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myathletes.databinding.MainmenuBinding


class Mainmenu : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding: MainmenuBinding =
            DataBindingUtil.inflate(inflater, R.layout.mainmenu,container, false)
        return binding.root



    }



}