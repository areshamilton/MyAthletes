package com.example.myathletes

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myathletes.databinding.TimerBinding
import com.example.myathletes.util.PrefUtil


class Timer : Fragment() {
    enum class TimerState{
        Stopped, Paused, Running
    }

    private lateinit var timer: CountDownTimer
    private var timerLengthSeconds = 0L
    private var timerState = TimerState.Stopped
    private var secondsRemaining = 0L



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = TimerBinding.inflate(layoutInflater)

        binding.backButton.setOnClickListener { view: View ->
            view.findNavController().navigate(TimerDirections.actionTimerToHomePage())
        }

//        binding.startTimer.setOnClickListener { v -> startTimer()
//            timerState = TimerState.Running
//            updateButtons()}
//        binding.pauseTimer.setOnClickListener { v -> timer.cancel()
//            timerState = TimerState.Paused
//            updateButtons()}
//
//        binding.stopTimer.setOnClickListener { v -> timer.cancel()
//            onTimerFinished()}
        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.timer, container, false)
    }

    override fun onResume() {
        super.onResume()
        initTimer()
    }

    override fun onPause() {
        super.onPause()
        if(timerState == TimerState.Running){
            timer.cancel()
        } else if(timerState == TimerState.Paused){
            //TODO: show notification
        }

//        PrefUtil.setPreviousTimerLengthSeconds(timerLengthSeconds, this)
//        PrefUtil.setSecondsRemaining(secondsRemaining, this)
//        PrefUtil.setTimerState(timerState, this)
    }

    private fun initTimer(){
//        timerState = PrefUtil.getTimerState(this)

        if(timerState == TimerState.Stopped)
            setNewTimerLength()
        else
            setPreviousTimerLength()

//        secondsRemaining = if(timerState == TimerState.Running || timerState == TimerState.Paused)
//            PrefUtil.getSecondsRemaining(this)
//        else // keeps the timer running since it is saved in the paused/stopped
//            timerLengthSeconds


        // resume where we left off
        if(timerState == TimerState.Running) {
            startTimer()
        }

        updateButtons()
        updateCountdownUI()
    }

    private fun onTimerFinished(){
        timerState = TimerState.Stopped

        setNewTimerLength()
//        progress_bar.progress = 0

//        PrefUtil.setSecondsRemaining(timerLengthSeconds, this)
        secondsRemaining = timerLengthSeconds
        updateButtons()
        updateCountdownUI()
    }

    private fun startTimer(){
        timerState = TimerState.Running
        timer = object : CountDownTimer(secondsRemaining * 1000, 1000){
            override fun onFinish() = onTimerFinished()
            override fun onTick(millisecondsUntilFinished: Long) {
                secondsRemaining = millisecondsUntilFinished / 1000
                updateCountdownUI()
            }
        }.start()
    }

    private fun setNewTimerLength(){
//        val lengthInMinutes = PrefUtil.getTimerLength(this)
//        timerLengthSeconds = (lengthInMinutes * 60L)
//        progress_bar.max = timerLengthSeconds.toInt()
    }

    private fun setPreviousTimerLength(){
//        timerLengthSeconds = PrefUtil.getPreviousTimerLengthSeconds(this)
//        progress_bar.max = timerLengthSeconds.toInt()
    }

    private fun updateCountdownUI(){
        val minutesUntilFinished = secondsRemaining / 60
        val secondsInMinutesUntilFinished = secondsRemaining - minutesUntilFinished * 60
        val secondsString = secondsInMinutesUntilFinished.toString()
//        time_count_down.text = "$minutesUntilFinished: ${
//            if(secondsString.length == 2)
//                secondsString
//            else
//                "0" + secondsString
//        }"
//
//        progress_bar.progress = (timerLengthSeconds - secondsRemaining).toInt()
    }

    private fun updateButtons(){
        when(timerState){
//            TimerState.Running->{
//                startTimer.isEnabled = false
//                pauseTimer.isEnabled = true
//                stopTimer.isEnabled = true
//            }
//            TimerState.Stopped->{
//                startTimer.isEnabled = true
//                pauseTimer.isEnabled = false
//                stopTimer.isEnabled = false
//            }
//            TimerState.Paused->{
//                startTimer.isEnabled = true
//                pauseTimer.isEnabled = false
//                stopTimer.isEnabled = true
//            }
        }
    }

}