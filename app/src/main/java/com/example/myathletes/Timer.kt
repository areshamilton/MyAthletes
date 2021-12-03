package com.example.myathletes

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myathletes.databinding.TimerBinding
import java.util.*

class Timer : Fragment() {
    private val startTime: Long = 600000

    private var mCountDownTimer: CountDownTimer? = null
    private var mTimerRunning = false
    private var mTimeLeftInMillis = startTime
    private var mEndTime: Long = 0

    // Store the view binding as a property so it is accessible to any method
    lateinit var binding: TimerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = TimerBinding.inflate(layoutInflater)

        /** Retrieve arguments passed by the navigate method call and store
         * them in a variable called args.
         */
        val args = TimerArgs.fromBundle(requireArguments())
        binding.workoutName.text ="Current Workout: ${args.workout}"

        binding.backButton.setOnClickListener { view: View ->
            view.findNavController().navigate(TimerDirections.actionTimerToHomePage())
        }

        binding.startPauseTimer.setOnClickListener {
            if (mTimerRunning) {
                pauseTimer()
            } else {
                startTimer()
            }
        }
        binding.resetTimer.setOnClickListener { resetTimer() }
        updateCountDownText()

        //Place holder for the workout database/array to go to next workout when button is clicked
//        binding.nextWorkoutButton.setOnClickListener { view: View ->
//          workout[x].name
//        }

        return binding.root
    }


    private fun startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis
        mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                mTimerRunning = false
                updateButtons()
            }
        }.start()
        mTimerRunning = true
        updateButtons()
    }

    private fun pauseTimer() {
        mCountDownTimer!!.cancel()
        mTimerRunning = false
        updateButtons()
    }

    private fun resetTimer() {
        mTimeLeftInMillis = startTime
        updateCountDownText()
        updateButtons()
    }

    private fun updateCountDownText() {
        val minutes = (mTimeLeftInMillis / 1000).toInt() / 60
        val seconds = (mTimeLeftInMillis / 1000).toInt() % 60
        val timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
//        mTextViewCountDown!!.text = timeLeftFormatted
        binding.timeCountDown.text = timeLeftFormatted
    }

    private fun updateButtons() {
        if (mTimerRunning) {
            binding.resetTimer.visibility = View.INVISIBLE
            binding.startPauseTimer.setText("Pause")
        } else {
            binding.startPauseTimer.setText("Start")
            if (mTimeLeftInMillis < 1000) {
                binding.startPauseTimer.visibility = View.INVISIBLE
            } else {
                binding.startPauseTimer.visibility = View.VISIBLE
            }
            if (mTimeLeftInMillis < startTime) {
                binding.resetTimer.visibility = View.VISIBLE
            } else {
                binding.resetTimer.visibility = View.INVISIBLE
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save view hierarchy
        super.onSaveInstanceState(outState)

        outState.putLong("millisLeft", mTimeLeftInMillis)
        outState.putBoolean("timerRunning", mTimerRunning)
        outState.putLong("endTime", mEndTime)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            mTimeLeftInMillis = savedInstanceState.getLong("millisLeft")
            mTimerRunning = savedInstanceState.getBoolean("timerRunning")
            updateCountDownText()
            updateButtons()
            if (mTimerRunning) {
                mEndTime = savedInstanceState.getLong("endTime")
                mTimeLeftInMillis = mEndTime - System.currentTimeMillis()
                startTimer()
            }
        }
    }


}