package com.example.myathletes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myathletes.databinding.CalculatorBinding
import kotlin.math.roundToInt

class Calculator : Fragment() {

    private var currentBox = 0
    private var currentWeight = 0.00
    private var currentBpm = 0.00
    private var targetBpm = 0.00
    private var nextLift = 0.00

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: CalculatorBinding =
            DataBindingUtil.inflate(inflater, R.layout.calculator,container, false)

        binding.currWeightBox.setOnClickListener{
            currentBox = 1
            binding.currWeightBox.background = getResources().getDrawable(R.drawable.border_pressed)
            binding.currBpmBox.background = getResources().getDrawable(R.drawable.border)
            binding.tarBpmBox.background = getResources().getDrawable(R.drawable.border)
        }

        binding.currBpmBox.setOnClickListener{
            currentBox = 2
            binding.currWeightBox.background = getResources().getDrawable(R.drawable.border)
            binding.currBpmBox.background = getResources().getDrawable(R.drawable.border_pressed)
            binding.tarBpmBox.background = getResources().getDrawable(R.drawable.border)
        }

        binding.tarBpmBox.setOnClickListener{
            currentBox = 3
            binding.currWeightBox.background = getResources().getDrawable(R.drawable.border)
            binding.currBpmBox.background = getResources().getDrawable(R.drawable.border)
            binding.tarBpmBox.background = getResources().getDrawable(R.drawable.border_pressed)
        }

        binding.buttonZero.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("0")
                2 -> binding.currBpmBox.append("0")
                3 -> binding.tarBpmBox.append("0")
                else -> {}
            }
        }

        binding.buttonOne.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("1")
                2 -> binding.currBpmBox.append("1")
                3 -> binding.tarBpmBox.append("1")
                else -> {}
            }
        }

        binding.buttonTwo.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("2")
                2 -> binding.currBpmBox.append("2")
                3 -> binding.tarBpmBox.append("2")
                else -> {}
            }
        }

        binding.buttonThree.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("3")
                2 -> binding.currBpmBox.append("3")
                3 -> binding.tarBpmBox.append("3")
                else -> {}
            }
        }

        binding.buttonFour.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("4")
                2 -> binding.currBpmBox.append("4")
                3 -> binding.tarBpmBox.append("4")
                else -> {}
            }
        }

        binding.buttonFive.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("5")
                2 -> binding.currBpmBox.append("5")
                3 -> binding.tarBpmBox.append("5")
                else -> {}
            }
        }

        binding.buttonSix.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("6")
                2 -> binding.currBpmBox.append("6")
                3 -> binding.tarBpmBox.append("6")
                else -> {}
            }
        }

        binding.buttonSeven.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("7")
                2 -> binding.currBpmBox.append("7")
                3 -> binding.tarBpmBox.append("7")
                else -> {}
            }
        }

        binding.buttonEight.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("8")
                2 -> binding.currBpmBox.append("8")
                3 -> binding.tarBpmBox.append("8")
                else -> {}
            }
        }

        binding.buttonNine.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append("9")
                2 -> binding.currBpmBox.append("9")
                3 -> binding.tarBpmBox.append("9")
                else -> {}
            }
        }

        binding.buttonDecimal.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.append(".")
                2 -> binding.currBpmBox.append(".")
                3 -> binding.tarBpmBox.append(".")
                else -> {}
            }
        }

        binding.buttonClear.setOnClickListener{
            when (currentBox) {
                1 -> binding.currWeightBox.text = null
                2 -> binding.currBpmBox.text = null
                3 -> binding.tarBpmBox.text = null
                else -> {}
            }
        }

        binding.buttonCalc.setOnClickListener{
            if(binding.currWeightBox.text.toString() != "" && binding.currBpmBox.text.toString() != "" && binding.tarBpmBox.text.toString() != "")
            {
                currentWeight = binding.currWeightBox.text.toString().toDouble()
                currentBpm = binding.currBpmBox.text.toString().toDouble()
                targetBpm = binding.tarBpmBox.text.toString().toDouble()
                nextLift = (currentWeight * (targetBpm / currentBpm))
                binding.nextLiftBox.text = nextLift.roundToInt().toString()
            }
            else {
                Unit
            }

        }

        return binding.root
    }
}