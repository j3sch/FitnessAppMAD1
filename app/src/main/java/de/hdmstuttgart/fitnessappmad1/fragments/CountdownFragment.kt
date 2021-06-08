package de.hdmstuttgart.fitnessappmad1.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessappmad1.R
import kotlinx.android.synthetic.main.fragment_countdown.*


class CountdownFragment : Fragment(R.layout.fragment_countdown) {

    private var isCountdownRunning: Boolean = true;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startCountdown()

        btnStartStop.setOnClickListener {
            if (isCountdownRunning) {
                stopCountdown()
                isCountdownRunning = false
            } else {
                resumeCountdown()
                isCountdownRunning = true
            }
        }
    }

    private fun startCountdown() {
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvCountdown.text = (millisUntilFinished / 1000).toString()
                pbCountdown.progress = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                tvCountdown.text = "done!"
            }
        }.start()

    }

    private fun stopCountdown() {

    }

    private fun resumeCountdown() {

    }
}
