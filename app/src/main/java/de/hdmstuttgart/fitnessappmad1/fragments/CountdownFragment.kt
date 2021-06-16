package de.hdmstuttgart.fitnessappmad1.fragments

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import de.hdmstuttgart.fitnessappmad1.Communicator
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_countdown.*
import kotlinx.coroutines.*

class CountdownFragment : Fragment(R.layout.fragment_countdown) {

    private lateinit var communicator: Communicator

    private val scope = CoroutineScope(Dispatchers.Main)
    private var isPaused = false
    private var resumeFromMillis: Long = 0

    private val CHANNEL_ID = "channelID"
    private val NOTIFICATION_ID = 0
    lateinit var notification: Notification
    lateinit var notificationManager: NotificationManagerCompat

    private val numberExercises = 7;
    private var currentExercise = 0;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        communicator = activity as Communicator
        setHasOptionsMenu(true)
        startCountdown(60000, 10)

        btnStartStop.setOnClickListener {
            if (!isPaused) {
                isPaused = true
            } else {
                isPaused = false
                startCountdown(resumeFromMillis, 100)
            }
        }

        tvLast.setOnClickListener {
            tvExercise.text = "Klimmzuege"
            scope.launch {
                lastButton()
            }
        }

        tvCurrent.setOnClickListener {
            tvExercise.text = "Exercise"
            scope.launch {
                currentButton()
            }
        }

        tvNext.setOnClickListener {
            if (currentExercise < numberExercises) {
                currentExercise++
                tvExercise.text = "Liegestuetzen"
                scope.launch {
                    nextButton()
                }
            } else {
                communicator.switchToFinish()
            }
        }

        val intent = Intent(requireContext(), MainActivity::class.java).apply {
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
                val textTimeRemaining = millisUntilFinished / 1000
                val circleTimeRemaining = millisUntilFinished / 10
                if (isPaused) {
                    tvCountdown.text = textTimeRemaining.toString()
                    pbCountdown.progress = circleTimeRemaining.toInt()
                    resumeFromMillis = millisUntilFinished
                    cancel()
                } else {
                    try {
                        tvCountdown.text = textTimeRemaining.toString()
                        pbCountdown.progress = circleTimeRemaining.toInt()
                    } catch (e: Exception) {
                        cancel()
                        e.printStackTrace()
                    }
                }
            }
            override fun onFinish() {
                notificationManager.notify(NOTIFICATION_ID, notification)
                tvCountdown.text = "done!"
            }
        }.start()
    }

    private suspend fun nextButton() {
        isPaused = true
        delay(1000)
        withContext (Dispatchers.Main) {
            isPaused = false
            startCountdown(60000, 100)
        }
    }

    private suspend fun currentButton() {
        isPaused = true
        delay(1000)
        withContext (Dispatchers.Main) {
            isPaused = false
            startCountdown(60000, 100)
        }
    }

    private suspend fun lastButton() {
        isPaused = true
        delay(1000)
        withContext (Dispatchers.Main) {
            isPaused = false
            startCountdown(60000, 100)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_exit, menu)
    }
}
