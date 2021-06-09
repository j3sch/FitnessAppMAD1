package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessappmad1.R
import kotlinx.android.synthetic.main.fragment_countdown.*

class CountdownFragment : Fragment(R.layout.fragment_countdown) {

    private var isPaused = false
    private var resumeFromMillis: Long = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startCountdown(60000, 1000)

        btnStartStop.setOnClickListener {
            if (!isPaused) {
                isPaused = true
            } else {
                isPaused = false
                startCountdown(resumeFromMillis, 1000)

            }
        }
    }

    private fun startCountdown(millisInFuture: Long,countDownInterval: Long) {
        object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val timeRemaining = millisUntilFinished / 1000
                if (isPaused) {
                    tvCountdown.text = timeRemaining.toString()
                    pbCountdown.progress = timeRemaining.toInt()
                    resumeFromMillis = millisUntilFinished
                    cancel()
                } else {
                    tvCountdown.text = timeRemaining.toString()
                    pbCountdown.progress = timeRemaining.toInt()
                }
            }

            override fun onFinish() {
                tvCountdown.text = "done!"
            }
        }.start()
    }
}
