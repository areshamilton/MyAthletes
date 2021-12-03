package com.example.myathletes

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myathletes.databinding.TimerBinding
import java.util.*

class Timer : Fragment() {

    private var mCountDownTimer: CountDownTimer? = null
    private var mTimerRunning = false
    private var mStartTimeInMillis: Long = 60000
    private var mTimeLeftInMillis: Long = 0
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
        /*val args = TimerArgs.fromBundle(requireArguments())
        binding.workoutName.text ="Current Workout: ${args.workout}"
        }*/
        binding.progressBar.progress = 100

        binding.startPauseTimer.setOnClickListener {
            if (mTimerRunning) {
                pauseTimer()
            } else {
                startTimer()
            }
        }
        binding.resetTimer.setOnClickListener { resetTimer() }
        updateCountDownText()

        binding.buttonSet.setOnClickListener {
            var input = binding.editTextInput.text.toString()

            var millisInput = input.toLong() * 60000

            setTime(millisInput)
            binding.editTextInput.setText("")
        }

        //Place holder for the workout database/array to go to next workout when button is clicked
//        binding.nextWorkoutButton.setOnClickListener { view: View ->
//          workout[x].name
//        }

        return binding.root
    }

    private fun setTime(milliseconds: Long){
        mStartTimeInMillis = milliseconds
        resetTimer()
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
                updateWatchUI()
            }
        }.start()
        mTimerRunning = true
        updateWatchUI()
    }

    private fun pauseTimer() {
        mCountDownTimer!!.cancel()
        mTimerRunning = false
        updateWatchUI()
    }

    private fun resetTimer() {
        mTimeLeftInMillis = mStartTimeInMillis
        updateCountDownText()
        updateWatchUI()
    }

    private fun updateCountDownText() {
        val hours   = (mTimeLeftInMillis / 1000).toInt() / 3600
        val minutes = ((mTimeLeftInMillis / 1000).toInt() % 3600) / 60
        val seconds = (mTimeLeftInMillis / 1000).toInt() % 60

        var timeLeftFormatted: String = if(hours > 0){
            String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, seconds)
        } else{
            String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        }

        binding.progressBar.progress = ((mTimeLeftInMillis.toDouble() / mStartTimeInMillis) * 100).toInt()
//        Toast.makeText(activity, "Current progress : ${binding.progressBar.progress}", Toast.LENGTH_SHORT).show()
        binding.timeCountDown.text = timeLeftFormatted
    }

    private fun updateWatchUI() {
        if (mTimerRunning) {
            binding.editTextInput.visibility = View.INVISIBLE
            binding.buttonSet.visibility = View.INVISIBLE
            binding.resetTimer.visibility = View.INVISIBLE
            binding.startPauseTimer.text = "Pause"
        } else {
            binding.editTextInput.visibility = View.VISIBLE
            binding.buttonSet.visibility = View.VISIBLE
            binding.startPauseTimer.text = "Start"
            if (mTimeLeftInMillis < 1000) {
                binding.startPauseTimer.visibility = View.INVISIBLE
            } else {
                binding.startPauseTimer.visibility = View.VISIBLE
            }
            if (mTimeLeftInMillis < mStartTimeInMillis) {
                binding.resetTimer.visibility = View.VISIBLE
            } else {
                binding.resetTimer.visibility = View.INVISIBLE
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save view hierarchy
        super.onSaveInstanceState(outState)

        outState.putLong("startTimeInMillis", mStartTimeInMillis)
        outState.putLong("millisLeft", mTimeLeftInMillis)
        outState.putBoolean("timerRunning", mTimerRunning)
        outState.putLong("endTime", mEndTime)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            mStartTimeInMillis = savedInstanceState.getLong("startTimeInMillis")
            mTimeLeftInMillis  = savedInstanceState.getLong("millisLeft")
            mTimerRunning = savedInstanceState.getBoolean("timerRunning")
            updateCountDownText()
            updateWatchUI()
            if (mTimerRunning) {
                mEndTime = savedInstanceState.getLong("endTime")
                mTimeLeftInMillis = mEndTime - System.currentTimeMillis()
                startTimer()
            }
        }
    }


}