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

class CountdownFragment : Fragment(R.layout.fragment_countdown) {

    private var isPaused = false
    private var millisInFuture: Long = 6000

    val CHANNEL_ID = "channelID"
    val NOTIFICATION_ID = 0
    lateinit var notification: Notification
    lateinit var notificationManager: NotificationManagerCompat


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timer.start()

        btnStartStop.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
            if (!isPaused) {
                isPaused = true
            } else {
                isPaused = false
                timer.start()
            }
        }

        tvNext.setOnClickListener {
            millisInFuture = 2312312
            println(millisInFuture)
            timer.cancel()
            timer.start()
            tvExercise.text = "Liegestuetzen"
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

    private val timer = object : CountDownTimer(millisInFuture, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val timeRemaining = millisUntilFinished / 1000
            if (isPaused) {
                tvCountdown.text = timeRemaining.toString()
                pbCountdown.progress = timeRemaining.toInt()
                millisInFuture = timeRemaining
                cancel()
            } else {
                tvCountdown.text = timeRemaining.toString()
                pbCountdown.progress = timeRemaining.toInt()
            }
        }
        override fun onFinish() {
            tvCountdown.text = "done!"
        }
    }
}
