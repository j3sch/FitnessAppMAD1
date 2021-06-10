package de.hdmstuttgart.fitnessappmad1.fragments

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.activity.ResultActivity
import kotlinx.android.synthetic.main.fragment_countdown.*
import kotlinx.coroutines.*

class CountdownFragment : Fragment(R.layout.fragment_countdown) {

    private val scope = CoroutineScope(Dispatchers.Main)
    private var isPaused = false
    private var resumeFromMillis: Long = 0

    val CHANNEL_ID = "channelID"
    val NOTIFICATION_ID = 0
    lateinit var notification: Notification
    lateinit var notificationManager: NotificationManagerCompat

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

        tvLast.setOnClickListener {
            scope.launch {
                lastButton()
            }
        }

        tvCurrent.setOnClickListener {
            scope.launch {
                currentButton()
            }
        }

        tvNext.setOnClickListener {
            scope.launch {
                nextButton()
            }
        }

        val intent = Intent(requireContext(), ResultActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(requireContext(), 0, intent, 0)

        notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_timer_24)
            .setContentTitle("Time over")
            .setContentText("sdsddssdds")
            .setContentIntent(pendingIntent)
            .build()

        notificationManager = NotificationManagerCompat.from(requireContext())
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
                notificationManager.notify(NOTIFICATION_ID, notification)
                tvCountdown.text = "done!"
            }
        }.start()
    }

    suspend fun nextButton() {
        isPaused = true
        delay(1000)
        withContext (Dispatchers.Main) {
            tvExercise.text = "Liegestuetzen"
            isPaused = false
            startCountdown(60000, 1000)
        }
    }

    suspend fun currentButton() {
        isPaused = true
        delay(1000)
        withContext (Dispatchers.Main) {
            tvExercise.text = "Exercise"
            isPaused = false
            startCountdown(60000, 1000)
        }
    }

    suspend fun lastButton() {
        isPaused = true
        delay(1000)
        withContext (Dispatchers.Main) {
            tvExercise.text = "Klimmzuege"
            isPaused = false
            startCountdown(60000, 1000)
        }
    }
}
